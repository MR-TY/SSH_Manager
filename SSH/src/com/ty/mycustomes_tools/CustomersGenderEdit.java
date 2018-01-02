package com.ty.mycustomes_tools;

import java.beans.PropertyEditorSupport;

import com.ty.enum1.Gender;

public class CustomersGenderEdit extends PropertyEditorSupport{
	
	//重写键与值对应的函数，因为现在不是从1开始了所以需要重写
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("正在解析---------------");
		int val=Integer.parseInt(text);
		
		for (Gender g : Gender.values()) {
			System.out.println("genderValue:"+Gender.values().toString());
			if(val==g.ordinal()){
				System.out.println("匹配成功-----------------------------------");
				this.setValue(g); 
				break;
			}
		}
	}
}
