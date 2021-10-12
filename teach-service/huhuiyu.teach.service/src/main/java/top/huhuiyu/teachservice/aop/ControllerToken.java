package top.huhuiyu.teachservice.aop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.utils.StringUtils;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.dao.UtilsDAO;
import top.huhuiyu.teachservice.entity.TbActions;
import top.huhuiyu.teachservice.entity.TbAdmin;
import top.huhuiyu.teachservice.entity.TbConfig;
import top.huhuiyu.teachservice.entity.TbTokenInfo;
import top.huhuiyu.teachservice.service.UtilService;
import top.huhuiyu.teachservice.utils.SystemConstants;

/**
 * 控制器token切面
 *
 * @author 胡辉煜
 */
@Aspect
@Component
public class ControllerToken extends BaseControllerAop {

  private static final Logger log = LoggerFactory.getLogger(ControllerToken.class);

  @Autowired
  private UtilService utilService;
  @Autowired
  private UtilsDAO utilsDAO;

  /**
   * 处理登陆信息拦截
   * 
   * @param pjp 切面信息
   * 
   * @throws Exception 处理发生错误
   */
  private void processAuthInfo(ProceedingJoinPoint pjp) throws Exception {
    MyBaseModel model = getMyBaseModel(pjp);
    if (model == null) {
      return;
    }
    // 登陆信息处理
    TbTokenInfo tbTokenInfo = model.makeTbTokenInfo();
    // 管理员登陆信息
    tbTokenInfo.setInfoKey(SystemConstants.LOGIN_ADMIN);
    TbAdmin admin = utilsDAO.queryAdminByToken(tbTokenInfo);
    log.debug("admin=====>{}", admin);
    model.setLoginAdmin(admin);
  }

  private BaseResult<?> processAuth(ProceedingJoinPoint pjp) throws Exception {
    MyBaseModel model = getMyBaseModel(pjp);
    RequestAttributes ra = RequestContextHolder.getRequestAttributes();
    ServletRequestAttributes sra = (ServletRequestAttributes) ra;
    HttpServletRequest request = sra.getRequest();
    TbActions actions = new TbActions();
    // 获取tomcat路径配置信息
    TbConfig config = new TbConfig();
    config.setConfigKey(SystemConstants.TOMCAT_CONTEXT_PATH_KEY);
    config = utilsDAO.queryConfig(config);
    log.debug("tomcat上下文信息{}", config);
    // 移除tomcat路径信息
    actions.setUrl(request.getRequestURI().replaceFirst(config.getConfigValue(), ""));
    actions = utilsDAO.queryByUrl(actions);
    // 查询不到的url不受管制
    if (actions == null) {
      return null;
    }
    // url的权限列表
    List<String> roles = getRoles(actions.getRole());
    List<String> check = new ArrayList<>();
    check.addAll(roles);
    // 登陆用户的权限列表
    List<String> userRoles = new ArrayList<>();
    // 管理员校验
    TbAdmin admin = model.getLoginAdmin();
    if (admin != null && !StringUtils.isEmpty(admin.getRole())) {
      userRoles.clear();
      userRoles = getRoles(admin.getRole());
    }
    check.retainAll(userRoles);
    // 不为空就表示权限吻合
    if (!check.isEmpty()) {
      return null;
    }
    return BaseResult.getFail(SystemConstants.NEED_LOGIN, SystemConstants.NEED_ROLE_LOGIN);
  }

  private List<String> getRoles(String role) {
    List<String> roles = new ArrayList<>(Arrays.asList(role.split(",")));
    return roles;
  }

  /**
   * 获取基础model信息
   * 
   * @param pjp 切面信息
   * 
   * @return model信息
   * 
   * @throws Exception 处理发生错误
   */
  private MyBaseModel getMyBaseModel(ProceedingJoinPoint pjp) throws Exception {
    MyBaseModel model = null;
    Object[] args = pjp.getArgs();
    for (Object arg : args) {
      if (arg instanceof MyBaseModel) {
        model = (MyBaseModel) arg;
        break;
      }
    }
    return model;
  }

  /**
   * 处理token信息
   * 
   * @param pjp 切面信息
   * 
   * @return token信息
   * 
   * @throws Exception 处理发生错误
   */
  private TbTokenInfo processToken(ProceedingJoinPoint pjp) throws Exception {
    // 通过注解获取是否需要token信息
    AnnoNoToken annoNoToken = pjp.getTarget().getClass().getAnnotation(AnnoNoToken.class);
    if (annoNoToken != null) {
      log.debug("获取到AnnoNoToken信息的对象:{}", pjp.getTarget().getClass().getName());
      return null;
    }
    MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
    annoNoToken = methodSignature.getMethod().getAnnotation(AnnoNoToken.class);
    if (annoNoToken != null) {
      log.debug("获取到AnnoNoToken信息的方法:{}", methodSignature.getMethod().getName());
      return null;
    }
    // model信息处理
    MyBaseModel model = getMyBaseModel(pjp);
    if (model != null) {
      RequestAttributes ra = RequestContextHolder.getRequestAttributes();
      ServletRequestAttributes sra = (ServletRequestAttributes) ra;
      HttpServletRequest request = sra.getRequest();
      // 头信息中的token
      model.setToken(request.getHeader(SystemConstants.TOKEN_KEY));
      // 请求参数中的token
      String requestToken = request.getParameter(SystemConstants.REQUEST_TOKEN_KEY);
      if (!StringUtils.isEmpty(requestToken)) {
        model.setToken(requestToken);
      }
      TbTokenInfo token = model.makeTbTokenInfo();
      // 校验并更新token信息
      token = utilService.checkToken(token);
      model.setToken(token.getToken());
      return token;
    }
    return null;
  }

  @Around("controller()")
  public Object around(ProceedingJoinPoint pjp) throws Throwable {
    log.debug("控制器切面token处理");
    TbTokenInfo token = processToken(pjp);
    log.debug("token信息：{}", token);
    // 登陆信息处理
    processAuthInfo(pjp);
    // 权限拦截
    BaseResult<?> check = processAuth(pjp);
    if (check != null) {
      return check;
    }
    Object result = pjp.proceed();
    // 如果应答为BaseResult且token存在就应答回去
    if ((token != null) && (result instanceof BaseResult)) {
      BaseResult<?> message = (BaseResult<?>) result;
      message.setToken(token.getToken());
    }
    return result;
  }
}