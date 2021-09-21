package top.huhuiyu.teachservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.teachservice.entity.TbClass;
import top.huhuiyu.teachservice.entity.TbStudent;

/**
 * tb_student表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbStudentDAO {
  /**
   * 查询全部tb_student
   * 
   * @param tbStudent 查询信息
   *
   * @return tb_student的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbStudent> queryAll(TbStudent tbStudent) throws Exception;

  /**
   * 按照主键查询tb_student
   *
   * @param tbStudent 主键信息
   * 
   * @return 主键查询tb_student的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbStudent queryByKey(TbStudent tbStudent) throws Exception;

  /**
   * 添加tb_student信息
   *
   * @param tbStudent tbStudent信息
   * 
   * @return 添加tbStudent信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbStudent tbStudent) throws Exception;

  /**
   * 修改tb_student信息
   *
   * @param tbStudent tbStudent信息
   * 
   * @return 修改tbStudent信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbStudent tbStudent) throws Exception;

  /**
   * 删除tb_student信息
   *
   * @param tbStudent tbStudent信息
   * 
   * @return 删除tbStudent信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbStudent tbStudent) throws Exception;

  /**
   * 删除班级的tb_student信息
   *
   * @param tbClass 班级信息
   * 
   * @return 删除班级的tbStudent信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int deleteByClass(TbClass tbClass) throws Exception;

}