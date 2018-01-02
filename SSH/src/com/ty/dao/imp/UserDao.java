package com.ty.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ty.BaseDao.BaseDao;
import com.ty.dao1.IUserDAO;
import com.ty.entity.User;
@Repository
public class UserDao extends BaseDao<User> implements IUserDAO{

	@Override
	public List<User> findUserByNameAndState(String name, int state) throws Exception {
		String sql="from User u where u.uLoginName like :name and state=:state";
		Query q=getSession().createQuery(sql);
		q.setParameter("name","%"+name+"%");
		q.setParameter("state",state);
		List<User> users=q.list();
		return users;
	}

	@Override
	public List<User> findUserByState(int state) throws Exception {
		String sql="from User u where u.state=:state";
		Query q=getSession().createQuery(sql);
		q.setParameter("state",state);
		List<User> users=q.list();
		return users;
	}

	@Override
	public String findPwdByuLoginName(String uLoginName) throws Exception {
		String sql="select u.uPwd from User u where u.uLoginName=?";
		Query q=getSession().createQuery(sql);
		q.setString(0, uLoginName);
		String uPwd=(String) q.uniqueResult();
		return uPwd;
	}

	@Override
	public String findPwdByEId(int eId) throws Exception {
		String sql = "select u.uPwd from User u where u.eId=:eId";
		Query q=getSession().createQuery(sql);
		q.setParameter("eId", eId);
		String uPwd=(String) q.uniqueResult();
		return uPwd;
	}
	
	public User findUserBynameAndpwd(String passWord1,String loginName) throws HibernateException, Exception{
		System.out.println(passWord1+"-----------"+loginName);
		String sql = "from User u where u.uPwd=:uPwd and u.uLoginName=:uLoginName";
		Query q=getSession().createQuery(sql);
		System.out.println("getSession():"+getSession());
		q.setParameter("uPwd", passWord1);
		q.setParameter("uLoginName", loginName);
		User user=(User) q.uniqueResult();
		System.out.println("user:"+user);
		return user;
	}
}
