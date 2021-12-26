package top.huhuiyu.teachservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbGoodsMessage;
import top.huhuiyu.teachservice.model.TbGoodsModel;
import top.huhuiyu.teachservice.service.TbGoodsService;

/**
 * 商品管理控制器
 * 
 * @author 胡辉煜
 */
@Api(tags = { "考试用接口" })
//@ApiIgnore
@RestController
@RequestMapping("/exam/goods")
public class TbGoodsController {

  @Autowired
  private TbGoodsService tbGoodsService;

  @ApiOperation(value = "查询商品信息", notes = "商品信息管理功能")
  @ApiImplicitParams({ @ApiImplicitParam(name = "page.pageNumber", value = "分页页码", paramType = "query"), @ApiImplicitParam(name = "page.pageSize", value = "分页大小", paramType = "query"),
      @ApiImplicitParam(name = "tbGoods.typeId", value = "所属商品分类 ", paramType = "query"), @ApiImplicitParam(name = "tbGoods.goodsName", value = "商品名称模糊查询", paramType = "query") })
  @PostMapping("/queryAll")
  public BaseResult<TbGoodsMessage> queryAll(TbGoodsModel model) throws Exception {
    return tbGoodsService.queryAll(model);
  }

  @ApiOperation(value = "添加商品信息", notes = "商品信息管理功能")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbGoods.typeId", value = "所属商品分类 ", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbGoods.goodsName", value = "商品名称", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbGoods.price", value = "商品价格", paramType = "query", required = true) })
  @PostMapping("/add")
  public BaseResult<TbGoodsMessage> add(TbGoodsModel model) throws Exception {
    return tbGoodsService.add(model);
  }

  @ApiOperation(value = "修改商品信息", notes = "商品信息管理功能，请注意，不能修改系统内置商品，必须是新增的商品数据")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbGoods.goodsId", value = "修改的商品编号", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbGoods.typeId", value = "所属商品分类 ", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbGoods.goodsName", value = "商品名称", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbGoods.price", value = "商品价格", paramType = "query", required = true) })
  @PostMapping("/update")
  public BaseResult<TbGoodsMessage> update(TbGoodsModel model) throws Exception {
    return tbGoodsService.update(model);
  }

  @ApiOperation(value = "删除商品信息", notes = "商品信息管理功能，请注意，不能删除系统内置商品，必须是新增的商品数据")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbGoods.goodsId", value = "删除的商品编号", paramType = "query", required = true) })
  @PostMapping("/delete")
  public BaseResult<TbGoodsMessage> delete(TbGoodsModel model) throws Exception {
    return tbGoodsService.delete(model);
  }

}