package com.ty.mycustomes_tools;

import java.beans.PropertyEditorSupport;

import com.ty.enum1.Gender;
import com.ty.enum1.Politics;

public class CustomersPolicsEdit extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		int val=Integer.parseInt(text);
		for (Politics p : Politics.values()) {
			if(val==p.ordinal()){
				System.out.println("Polics==========匹配成功-----------------------------------");
				this.setValue(p); 
				break;
			}
		}
	}
}
