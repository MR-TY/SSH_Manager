package com.ty.service1;

import java.util.List;

import com.ty.entity.Staff;

public interface IStaffService {
	/**
	 *发现全部的职位
	 */
	List<Staff> findStaffAll() throws Exception;
	
	/**
	 *通过名字模糊查找职位
	 */
	List<Staff> findStaffByNameLike(String name)throws Exception ;
	/**
	 * 通过id删除职位
	 */
	void deleteStaffById(int id)throws Exception ;
	/**
	 * 通过多个id删除职位
	 */
	void deleteStaffByIds(int... ids)throws Exception ;
	/**
	 * 更新职位
	 */
	void updateStaff(Staff staff)throws Exception ;
	/**
	 *删除职位
	 */
	void deleteStaffByObj(Staff staff)throws Exception ;
	
	/**
	 *保存职位
	 */
	void saveStaff(Staff staff) throws Exception;
    /**
     * 通过id发现职位
     */
	Staff findStaffById(int staffId) throws Exception;
}
