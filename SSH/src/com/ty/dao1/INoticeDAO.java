package com.ty.dao1;

import java.util.List;

import com.ty.IBaseDao.IBaseDao;
import com.ty.entity.Notice;

public interface INoticeDAO extends IBaseDao<Notice>{
	/**
	 * 通过名字发现公告
	* @Function: INoticeDAO.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年4月9日 上午12:05:49 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月9日       water           v1.0.0               修改原因
	 */
	Notice findNoticeByName(String noticeName)throws Exception; 
	 /**
	  * 通过id发现公告
	 * @Function: INoticeDAO.java
	 * @Description: 该函数的功能描述
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: water
	 * @date: 2018年4月9日 上午12:06:03 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2018年4月9日       water           v1.0.0               修改原因
	  */
	Notice findNoticeById(int nitoceId)throws Exception;
	
	public List<Notice> findNotceLikeByName(String noticeName) throws Exception;
}
