package top.huhuiyu.teachservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.teachservice.entity.TbDept;
import top.huhuiyu.teachservice.entity.TbEmployee;

/**
 * tb_employee表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbEmployeeDAO {
  /**
   * 查询全部tb_employee
   *
   * @param tbEmployee 查询过滤条件
   * 
   * @return tb_employee的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbEmployee> queryAll(TbEmployee tbEmployee) throws Exception;

  /**
   * 按照主键查询tb_employee
   *
   * @param tbEmployee 主键信息
   * 
   * @return 主键查询tb_employee的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbEmployee queryByKey(TbEmployee tbEmployee) throws Exception;

  /**
   * 添加tb_employee信息
   *
   * @param tbEmployee tbEmployee信息
   * 
   * @return 添加tbEmployee信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbEmployee tbEmployee) throws Exception;

  /**
   * 修改tb_employee信息
   *
   * @param tbEmployee tbEmployee信息
   * 
   * @return 修改tbEmployee信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbEmployee tbEmployee) throws Exception;

  /**
   * 删除tb_employee信息
   *
   * @param tbEmployee tbEmployee信息
   * 
   * @return 删除tbEmployee信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbEmployee tbEmployee) throws Exception;

  /**
   * 删除部门的员工信息
   *
   * @param tbDept 部门信息
   * 
   * @return 删除部门的员工信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int deleteByDept(TbDept tbDept) throws Exception;

}