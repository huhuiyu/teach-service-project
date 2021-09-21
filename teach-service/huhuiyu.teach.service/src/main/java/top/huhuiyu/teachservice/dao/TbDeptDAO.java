package top.huhuiyu.teachservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.teachservice.entity.TbDept;

/**
 * tb_dept表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbDeptDAO {
  /**
   * 查询全部tb_dept
   *
   * @return tb_dept的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbDept> queryAll() throws Exception;

  /**
   * 按照主键查询tb_dept
   *
   * @param tbDept 主键信息
   * 
   * @return 主键查询tb_dept的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbDept queryByKey(TbDept tbDept) throws Exception;

  /**
   * 按照部门名称查询tb_dept
   *
   * @param tbDept 部门名称信息
   * 
   * @return 部门名称查询tb_dept的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbDept queryByName(TbDept tbDept) throws Exception;

  /**
   * 添加tb_dept信息
   *
   * @param tbDept tbDept信息
   * 
   * @return 添加tbDept信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbDept tbDept) throws Exception;

  /**
   * 修改tb_dept信息
   *
   * @param tbDept tbDept信息
   * 
   * @return 修改tbDept信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbDept tbDept) throws Exception;

  /**
   * 删除tb_dept信息
   *
   * @param tbDept tbDept信息
   * 
   * @return 删除tbDept信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbDept tbDept) throws Exception;

}