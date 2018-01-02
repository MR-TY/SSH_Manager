package com.ty.service1;

import java.io.Serializable;
import java.util.List;

import com.ty.entity.Employee;
import com.ty.entity.User;

public interface IUserService {
	/**
	 * 查询所有的用户
	* @Function: IUserService.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年4月8日 上午11:01:49 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月8日       water           v1.0.0               修改原因
	 */
	List<User> findUserAll() throws Exception;
	/**
	 * 通过id查询用户
	* @Function: IUserService.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年4月8日 上午11:02:06 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月8日       water           v1.0.0               修改原因
	 */
	User findUserById(Serializable id) throws Exception;
	/**
	 * 通过id删除用户
	* @Function: IUserService.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年4月8日 上午11:02:21 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月8日       water           v1.0.0               修改原因
	 */
	void deleteUserById(int id) throws Exception;
	/**
	 * 通过id删除多个用户
	* @Function: IUserService.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年4月8日 上午11:02:38 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月8日       water           v1.0.0               修改原因
	 */
	void deleteUserByIds(int[] i) throws Exception;
	/**
	 * 发现用户通过用户的名字和状态
	* @Function: IUserService.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年4月8日 上午11:02:57 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月8日       water           v1.0.0               修改原因
	 */
	List<User> findUserByNameAndState(String name,Integer state) throws Exception;
	/**
	 * 更新用户
	* @Function: IUserService.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年4月8日 上午11:03:22 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月8日       water           v1.0.0               修改原因
	 */
	void updateUser(User user) throws Exception;
	/**
	 * 发现用户通过用户的名字和密码
	* @Function: IUserService.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年4月8日 上午11:04:02 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月8日       water           v1.0.0               修改原因
	 */
	User findUserByUserNameAndPassword(User user) throws Exception;
	/**
	 * 通过id发现密码
	* @Function: IUserService.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年4月8日 下午1:22:36 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月8日       water           v1.0.0               修改原因
	 */
	public String findPwdByEId(int eId) throws Exception;
	/**
	 * 增加一个用户
	* @Function: IUserService.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年1月3日 上午9:03:20 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年1月3日       water           v1.0.0               修改原因
	 */
	public void addOneUser(User user);
	
}
