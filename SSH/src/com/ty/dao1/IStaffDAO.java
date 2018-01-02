package com.ty.dao1;

import com.ty.entity.Dept;
import com.ty.entity.Staff;

public interface IStaffDAO {
	public Staff findStaffById(int id) throws Exception;
}
