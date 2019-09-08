package com.hsq.springboot.study.domain;

import java.io.Serializable;

public class RQ_City implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 768489910630368107L;
	private Long cityId;
	private String descripton;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

}
