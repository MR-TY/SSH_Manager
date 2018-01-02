package com.ty.Utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * M5发散工具类，输入的密码，发散为其他的数字，这样别人就不能看出密码，而且更加安全
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: M5Utils.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: water
* @date: 2018年4月8日 下午12:44:10 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年4月8日       water           v1.0.0               修改原因
 */
public class M5Utils {
	public static String getM5Parame(String val) throws NoSuchAlgorithmException{
		if (val == null||val.equals("")) {
			throw new RuntimeException("传入的值有问题");
		}
		MessageDigest digest=MessageDigest.getInstance("Md5");
		digest.update(val.getBytes());
		return (new BigInteger(1,digest.digest()).toString(16));
	}
}
