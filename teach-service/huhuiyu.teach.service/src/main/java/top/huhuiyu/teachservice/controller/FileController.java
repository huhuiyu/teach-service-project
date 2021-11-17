package top.huhuiyu.teachservice.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.aop.AnnoNoToken;
import top.huhuiyu.teachservice.message.TbFileMessage;
import top.huhuiyu.teachservice.model.TbFileModel;
import top.huhuiyu.teachservice.service.TbFileService;

/**
 * 用户上传文件管理的控制器
 *
 * @author 胡辉煜
 */
@Api(tags = { "文件信息管理" })
@RestController
@RequestMapping("/file")
public class FileController {

  @Autowired
  private TbFileService tbFileService;

  @ApiOperation(value = "上传文件", notes = "本接口需要用户登陆，且需要FormData提交数据，无法通过本界面测试")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbFile.fileinfo", value = "文件描述信息", paramType = "query"), @ApiImplicitParam(name = "file", value = "上传文件", paramType = "form-data", required = true) })
  @PostMapping("/upload")
  public BaseResult<TbFileMessage> upload(TbFileModel model, MultipartFile file) throws Exception {
    return tbFileService.add(model, file);
  }

  @AnnoNoToken
  @ApiOperation(value = "下载文件", notes = "应答结果为文件，无法通过本界面测试，不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbFile.fid", value = "下载文件id", paramType = "query", required = true) })
  @GetMapping("/download")
  public void download(TbFileModel model, HttpServletResponse response) throws Exception {
    tbFileService.download(model, response);
  }

  @ApiOperation(value = "查询文件", notes = "需要用户登陆")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbFile.fileinfo", value = "文件描述模糊查询", paramType = "query"), @ApiImplicitParam(name = "tbFile.filename", value = "文件名称模糊查询", paramType = "query"),
      @ApiImplicitParam(name = "tbFile.contentType", value = "文件类型模糊查询", paramType = "query"), @ApiImplicitParam(name = "page.pageNumber", value = "分页页码", paramType = "query"),
      @ApiImplicitParam(name = "page.pageSize", value = "分页大小", paramType = "query") })
  @PostMapping("/query")
  public BaseResult<TbFileMessage> query(TbFileModel model) throws Exception {
    return tbFileService.queryAllByUser(model);
  }

  @ApiOperation(value = "删除文件", notes = "需要用户登陆")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbFile.fid", value = "要删除的文件id", paramType = "query", required = true) })
  @PostMapping("/delete")
  public BaseResult<TbFileMessage> delete(TbFileModel model) throws Exception {
    return tbFileService.deleteByUser(model);
  }
}