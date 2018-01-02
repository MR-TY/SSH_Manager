package com.ty.IBaseDao;

import java.io.Serializable;
import java.util.List;

import com.ty.entity.Dept;
import com.ty.entity.Notice;


public interface IBaseDao<T> {
	 /**
     * ��ѯ���еĶ���
     * @Title: findObjectAll 
     * @Description: TODO
     * @param @return    
     * @return List<T>    
     * @throws
     */
	List<T> findObjectAll();
	/**
	 * ����һ������
	 * @Title: saveObject 
	 * @Description: TODO
	 * @param @param t    
	 * @return void    
	 * @throws
	 */
	void saveObject(T t);
	
	/**
	 * �޸�һ������
	 * @Title: updateObject 
	 * @Description: TODO
	 * @param @param t    
	 * @return void    
	 * @throws
	 */
	void updateObject(T t);
	/**
	 * 通过id进行查找
	* @Function: IBaseDao.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年1月1日 下午10:29:46 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年1月1日       water           v1.0.0               修改原因
	 */
	T findObject(Serializable id) throws Exception;
	/**
	 * 多个id的删除
	* @Function: IBaseDao.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年1月1日 下午10:28:03 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年1月1日       water           v1.0.0               修改原因
	 */
	void deleteTByIds(String tableName, String idName,int[] ids) throws Exception;
	/**
	 * 通过名字的模糊查询
	* @Function: IBaseDao.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年1月1日 下午10:28:45 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年1月1日       water           v1.0.0               修改原因
	 */
	public List<T> findTByNameLike(String name,String nameVal) throws Exception;
	/**
	 * 根据id删除一个
	* @Function: IBaseDao.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年4月8日 下午11:59:40 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月8日       water           v1.0.0               修改原因
	 */
	void deleteObject(Dept dept);
	

}
