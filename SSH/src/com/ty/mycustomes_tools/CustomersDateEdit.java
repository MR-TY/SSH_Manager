package com.ty.mycustomes_tools;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.springframework.util.StringUtils;

public class CustomersDateEdit extends PropertyEditorSupport{
	private DateFormat[] dateFormats;
	private DateFormat dateFormat;   
	private boolean allowEmpty;
	private int exactDateLength;
	
	public CustomersDateEdit(DateFormat[] dateFormats, boolean allowEmpty) {
		this.dateFormats = dateFormats;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = -1;
	}

	public CustomersDateEdit(DateFormat[] dateFormats, boolean allowEmpty, int exactDateLength) {
		this.dateFormats = dateFormats;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = exactDateLength;
	}

	public void setAsText(String text) throws IllegalArgumentException {
		if (this.allowEmpty && !StringUtils.hasText(text)) {
			// Treat empty String as null value.
			setValue(null);
		}
		else if (text != null && this.exactDateLength >= 0 && text.length() != this.exactDateLength) {
			throw new IllegalArgumentException(
					"Could not parse date: it is not exactly" + this.exactDateLength + "characters long");
		}
		else {
			    boolean b=false;
				//��Ϊ�ж��ָ�ʽ  ����������Ҫ ����
				for (DateFormat dataFormat : dateFormats) {
					try {
						setValue(dataFormat.parse(text));
						dateFormat=dataFormat;
						b=true;
						break;
					} catch (Exception e) {
						continue;
					}
				}
				if(!b){
					throw new RuntimeException("�������󣬸�ʽ����ȷ....");
				}
			}
		}


	public String getAsText() {
		Date value = (Date) getValue();
		return (value != null ? this.dateFormat.format(value) : "");
	}
}
