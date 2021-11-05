package top.huhuiyu.teachservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.huhuiyu.teachservice.entity.TbUserInfo;

/**
 * tb_user_info表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbUserInfoDAO {
  /**
   * 查询全部tb_user_info
   *
   * @return tb_user_info的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbUserInfo> queryAll() throws Exception;

  /**
   * 按照主键查询tb_user_info
   *
   * @param tbUserInfo 主键信息
   * 
   * @return 主键查询tb_user_info的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbUserInfo queryByKey(TbUserInfo tbUserInfo) throws Exception;

  /**
   * 添加tb_user_info信息
   *
   * @param tbUserInfo tbUserInfo信息
   * 
   * @return 添加tbUserInfo信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbUserInfo tbUserInfo) throws Exception;

  /**
   * 修改tb_user_info信息
   *
   * @param tbUserInfo tbUserInfo信息
   * 
   * @return 修改tbUserInfo信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbUserInfo tbUserInfo) throws Exception;

  /**
   * 删除tb_user_info信息
   *
   * @param tbUserInfo tbUserInfo信息
   * 
   * @return 删除tbUserInfo信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbUserInfo tbUserInfo) throws Exception;

}