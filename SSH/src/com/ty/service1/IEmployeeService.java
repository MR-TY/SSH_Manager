package com.ty.service1;

import java.util.List;

import com.ty.entity.Employee;

public interface IEmployeeService {
	/**
	 *发现全部的员工
	 */
	List<Employee> findEmployeeAll() throws Exception;
	
	/**
	 *通过名字模糊查找员工
	 */
	List<Employee> findEmployeeByNameLike(String name)throws Exception ;
	/**
	 * 通过id删除员工
	 */
	void deleteEmployeeById(int id)throws Exception ;
	/**
	 * 通过多个id删除员工
	 */
	void deleteEmployeeByIds(int... ids)throws Exception ;
	/**
	 * 更新员工
	 */
	void updateEmployee(Employee Employee)throws Exception ;
	/**
	 *删除员工
	 */
	void deleteEmployeeByObj(Employee Employee)throws Exception ;
	
	/**
	 *保存员工
	 */
	void saveEmployee(Employee Employee) throws Exception;
    /**
     * 通过id发现员工
     */
	Employee findEmployeeById(int dId) throws Exception;
	
	/**
	 * 多个条件进行员工查询
	* @Function: IEmployeeService.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年1月3日 下午8:07:25 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年1月3日       water           v1.0.0               修改原因
	 */
	public  List<Employee> findEmployeeByMany(int dId1, int staffId1, int genderId, String eName);
}
