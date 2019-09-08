package com.hsq.springboot.study.domain;

import java.time.LocalDateTime;

import com.hsq.springboot.study.enums.FinanceStatus;
import com.hsq.springboot.study.enums.Sex;

public class RQ {
    private   LocalDateTime end;
    private   FinanceStatus status;
    private   Sex sex;

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public FinanceStatus getStatus() {
		return status;
	}

	public void setStatus(FinanceStatus status) {
		this.status = status;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
    
	
   
}
