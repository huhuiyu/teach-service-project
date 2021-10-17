package top.huhuiyu.teachservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.huhuiyu.teachservice.entity.TbErrorInfo;

/**
 * tb_error_info表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbErrorInfoDAO {
  /**
   * 查询全部tb_error_info
   *
   * @return tb_error_info的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbErrorInfo> queryAll() throws Exception;

  /**
   * 按照主键查询tb_error_info
   *
   * @param tbErrorInfo 主键信息
   * 
   * @return 主键查询tb_error_info的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbErrorInfo queryByKey(TbErrorInfo tbErrorInfo) throws Exception;

  /**
   * 添加tb_error_info信息
   *
   * @param tbErrorInfo tbErrorInfo信息
   * 
   * @return 添加tbErrorInfo信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbErrorInfo tbErrorInfo) throws Exception;

  /**
   * 修改tb_error_info信息
   *
   * @param tbErrorInfo tbErrorInfo信息
   * 
   * @return 修改tbErrorInfo信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbErrorInfo tbErrorInfo) throws Exception;

  /**
   * 删除tb_error_info信息
   *
   * @param tbErrorInfo tbErrorInfo信息
   * 
   * @return 删除tbErrorInfo信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbErrorInfo tbErrorInfo) throws Exception;

}