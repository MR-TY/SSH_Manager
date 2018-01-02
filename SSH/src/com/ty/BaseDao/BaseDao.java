package com.ty.BaseDao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import com.ty.IBaseDao.IBaseDao;
import com.ty.entity.Dept;
import com.ty.entity.Notice;

public class BaseDao<T> implements IBaseDao<T> {
	Class<T> clazz = null;
	Object obj;

	public BaseDao() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
		obj=clazz.getName();
		System.out.println(clazz);
	}

	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<T> findObjectAll() {
		String sql = "from " + clazz.getName();
		Query query = getSession().createQuery(sql);
		return query.list();
	}

	@Override
	public T findObject(Serializable id) throws Exception{
		T t=(T)getSession().get(clazz, id);
		return t;
	}

	@Override
	public void saveObject(T t) {
		getSession().save(t);
		getSession().flush();
	}

	@Override
	public void deleteObject(Dept dept) {
		getSession().delete(dept);
	}

	/**
	 * SSH的一个bug需要提交事务才能进行更新
	* @see com.ty.IBaseDao.IBaseDao#updateObject(java.lang.Object)  
	* @Function: BaseDao.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author:  water
	* @date: 2018年4月8日 下午8:58:08 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月8日   	water           v1.0.0               修改原因
	 */
	@Override
	public void updateObject(T t) {
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
		System.out.println("进入更新的函数。。。。。。。。。。。。");
		getSession().update(t);
		getSession().flush();
//		transaction.commit();
	}
	@Override
	public void deleteTByIds(String tableName,String idName, int... ids) throws Exception {
		StringBuilder sql = new StringBuilder("delete from "+tableName);
		if (ids!=null) {
			sql.append(" where "+idName+" in(");
			for (int i=0;i<ids.length;i++) {
				if(i<ids.length-1){
					sql.append(ids[i]+",");
				}else{
					sql.append(ids[i]);
				}
			}
			sql.append(")");
		}
		System.out.println("sql語句："+sql);
		getSession().createSQLQuery(sql.toString()).executeUpdate();
	}
	@Override
	public List<T> findTByNameLike(String name, String nameVal) throws Exception {
		System.out.println("进入模糊查询");
		System.out.println("obj---------"+obj);
		String sql="from "+obj+" d where d."+name+" like ?";
		Query q=getSession().createQuery(sql);
		q.setString(0,"%"+nameVal+"%");
		List<T> t=q.list();
		return t;
	}
	
}
