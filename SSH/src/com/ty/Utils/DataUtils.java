package com.ty.Utils;

import java.text.SimpleDateFormat;

public class DataUtils {
	private static SimpleDateFormat[] formats = {
			new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyy/MM/dd"),
			new SimpleDateFormat("yyyy年MM月dd日")
	};
	
	public static SimpleDateFormat[] getFormates(){
		return formats;
	}
}
