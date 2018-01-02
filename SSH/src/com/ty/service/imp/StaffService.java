package com.ty.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ty.dao.imp.StaffDAO;
import com.ty.entity.Staff;
import com.ty.service1.IStaffService;

@Service
@Transactional
public class StaffService implements IStaffService {

	@Autowired
	private StaffDAO staffDAO;

	@Override
	public List<Staff> findStaffAll() throws Exception {
		return staffDAO.findObjectAll();
	}

	@Override
	public List<Staff> findStaffByNameLike(String name) throws Exception {
		if (name == null) {
			new RuntimeException("传入的参数为空");
		}
		List<Staff> staffs = staffDAO.findTByNameLike("staffName", name);
		return staffs;
	}

	@Override
	public void deleteStaffById(int id) throws Exception {
		deleteStaffByIds(new int[] { id });
	}

	@Override
	public void deleteStaffByIds(int... ids) throws Exception {
		if (null == ids) {
			throw new RuntimeException("不对");
		}
		staffDAO.deleteTByIds("tbl_staff", "staffId", ids);
	}

	@Override
	public void updateStaff(Staff staff) throws Exception {
		if (null == staff) {
			throw new RuntimeException("职位为空，不能进行更新");
		}
		staffDAO.updateObject(staff);
	}

	@Override
	public void deleteStaffByObj(Staff staff) throws Exception {

	}

	@Override
	public void saveStaff(Staff staff) throws Exception {
		staffDAO.saveObject(staff);
	}

	@Override
	public Staff findStaffById(int staffId) throws Exception {
		return staffDAO.findStaffById(staffId);
	}

}
