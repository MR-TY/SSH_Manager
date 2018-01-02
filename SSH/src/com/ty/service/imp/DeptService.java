package com.ty.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ty.BaseDao.BaseDao;
import com.ty.dao.imp.DeptDao;
import com.ty.dao.imp.UserDao;
import com.ty.entity.Dept;
import com.ty.entity.User;
import com.ty.service1.IDeptService;

@Service
@Transactional
public class DeptService implements IDeptService {
	@Autowired
	private DeptDao deptDao;

	@Override
	public List<Dept> findDeptAll() throws Exception {
		return deptDao.findObjectAll();
	}

	@Override
	public List<Dept> findDeptByNameLike(String name) throws Exception {
		if (name == null || name.equals("")) {
			new RuntimeException("名字为空");
		}
		return deptDao.findTByNameLike("dName", name);
	}

	@Override
	public void deleteDeptById(int id) throws Exception {
		deleteDeptByIds(new int[] { id });
	}

	@Override
	public void deleteDeptByIds(int... ids) throws Exception {
		if (null == ids) {
			throw new RuntimeException("不对");
		}
		deptDao.deleteTByIds("tbl_dept", "dId", ids);
	}

	@Override
	public void updateDept(Dept dept) throws Exception {
		if (null == dept) {
			throw new RuntimeException("部门为空，不能进行更新");
		}
		deptDao.updateObject(dept);
	}

	@Override
	public void deleteDeptByObj(Dept dept) throws Exception {
		try {
			deptDao.deleteObject(dept);
			;
		} catch (Exception e) {
			throw new RuntimeException("发生错误");
		}
	}

	@Override
	public void saveDept(Dept dept) throws Exception {
		deptDao.saveObject(dept);
	}

	@Override
	public Dept findDeptById(int dId) throws Exception {
		return deptDao.findDeptById(dId);
	}
}
