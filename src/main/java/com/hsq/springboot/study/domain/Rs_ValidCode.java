package com.hsq.springboot.study.domain;

import java.io.Serializable;

public class Rs_ValidCode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5808935994126074977L;
	public String code;
	public String image;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
