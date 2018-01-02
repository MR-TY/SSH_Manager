package com.ty.service.imp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ty.BaseDao.BaseDao;
import com.ty.Utils.M5Utils;
import com.ty.dao.imp.UserDao;
import com.ty.entity.Employee;
import com.ty.entity.User;
import com.ty.service1.IUserService;

@Service
@Transactional
public class UserService extends BaseDao<User> implements IUserService {
	@Autowired
	private UserDao userDAO;

	@Override
	public List<User> findUserAll() throws Exception {
		return userDAO.findObjectAll();
	}

	@Override
	public User findUserById(Serializable id) throws Exception {
		if (id == null) {
			throw new RuntimeException("id值为空");
		}
		return userDAO.findObject(id);
	}

	@Override
	public void deleteUserById(int id) throws Exception {
		deleteUserByIds(new int[] { (Integer) id });
	}

	@Override
	public void deleteUserByIds(int... ids) throws Exception {
		if(ids.length<=0){
			throw new RuntimeException("发生错");
		}
		userDAO.deleteTByIds("tbl_user","eId",ids);
	}

	@Override
	public List<User> findUserByNameAndState(String name, Integer state) throws Exception {
		if (name == null || name.equals("") && state != null) {
			return userDAO.findUserByState(state);
		} else if (name == null || name.equals("") && state == null) {
			return userDAO.findObjectAll();
		} else if (!name.equals("") && state == null) {
			return userDAO.findTByNameLike("uLoginName", name);
		}
		return userDAO.findUserByNameAndState(name, state);
	}

	@Override
	public void updateUser(User user) throws Exception {
		if (user.geteId() <= 0) {
			throw new RuntimeException("id值为空");
		}
		userDAO.updateObject(user);
	}

	@Override
	public User findUserByUserNameAndPassword(User user) throws Exception {
		System.out.println("User:"+user);
		String loginName = user.getuLoginName();
		String password = userDAO.findPwdByuLoginName(loginName);
		System.out.println("password:"+password);
		
		String passWord1 = M5Utils.getM5Parame(user.getuPwd());
		System.out.println("passWord1"+passWord1);
		if (password != null) {
			if (password.equals(passWord1)) {
				System.out.println("满足条件之后进行对象的查询");
				User user2 = userDAO.findUserBynameAndpwd(passWord1,loginName);
				System.out.println(user2);
				return user2;
			}
		}
		throw new RuntimeException("发生错误");
	}

	public String findPwdByEId(int eId) throws Exception {
		if (eId < 0) {
			throw new RuntimeException("id值为空");
		}
		return userDAO.findPwdByEId(eId);
	}

	public void addOneUser(User user) {
		if (user==null) {
			throw new RuntimeException("传入的对象为空");
		}
		userDAO.saveObject(user);
	}
}
