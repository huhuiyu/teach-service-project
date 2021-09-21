package top.huhuiyu.teachservice.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 控制器切点定义
 * 
 * @author 胡辉煜
 *
 */
public abstract class BaseControllerAop {

  @Pointcut("execution(public * top.huhuiyu.teachservice.controller..*.*(..))")
  public void controller() {
  }

}