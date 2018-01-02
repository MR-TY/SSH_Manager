package com.ty.service1;
import java.util.List;

import com.ty.entity.Dept;

public interface IDeptService {

	/**
	 *发现全部的部门
	 */
	List<Dept> findDeptAll() throws Exception;
	
	/**
	 *通过名字模糊查找部门
	 */
	List<Dept> findDeptByNameLike(String name)throws Exception ;
	/**
	 * 通过id删除部门
	 */
	void deleteDeptById(int id)throws Exception ;
	/**
	 * 通过多个id删除部门
	 */
	void deleteDeptByIds(int... ids)throws Exception ;
	/**
	 * 更新部门
	 */
	void updateDept(Dept dept)throws Exception ;
	/**
	 *删除部门
	 */
	void deleteDeptByObj(Dept dept)throws Exception ;
	
	/**
	 *保存部门
	 */
	void saveDept(Dept dept) throws Exception;
    /**
     * 通过id发现部门
     */
	Dept findDeptById(int dId) throws Exception;
}
