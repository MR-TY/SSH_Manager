package com.ty.dao1;

import java.util.List;

import com.ty.IBaseDao.IBaseDao;
import com.ty.entity.User;

public interface IUserDAO extends IBaseDao<User>{
	/**
	 * 通过状态和名字发现用户
	* @Function: IUserDAO.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年4月9日 上午12:04:43 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月9日       water           v1.0.0               修改原因
	 */
	List<User> findUserByNameAndState(String name,int state) throws Exception;
	/**
	 * 通过状态发现用户
	* @Function: IUserDAO.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年4月9日 上午12:05:05 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月9日       water           v1.0.0               修改原因
	 */
    List<User> findUserByState(int state) throws Exception;
    /**
     * 通过用户名发现密码
    * @Function: IUserDAO.java
    * @Description: 该函数的功能描述
    *
    * @param:描述1描述
    * @return：返回结果描述
    * @throws：异常描述
    *
    * @version: v1.0.0
    * @author: water
    * @date: 2018年4月9日 上午12:05:24 
    *
    * Modification History:
    * Date         Author          Version            Description
    *---------------------------------------------------------*
    * 2018年4月9日       water           v1.0.0               修改原因
     */
    String findPwdByuLoginName(String uLoginName)throws Exception;
    /**
     * 通过id发现密码
    * @Function: IUserDAO.java
    * @Description: 该函数的功能描述
    *
    * @param:描述1描述
    * @return：返回结果描述
    * @throws：异常描述
    *
    * @version: v1.0.0
    * @author: water
    * @date: 2018年4月8日 下午1:18:57 
    *
    * Modification History:
    * Date         Author          Version            Description
    *---------------------------------------------------------*
    * 2018年4月8日       water           v1.0.0               修改原因
     */
    public String findPwdByEId(int eId) throws Exception;
}
