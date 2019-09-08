package com.hsq.springboot.study.enums;

public enum FinanceStatus implements BaseEnum {
     Close("冻结",0),open("正常",1);
	
     private String desc;
     private int  code;
     
     FinanceStatus(String desc, int  status){
    	 this.desc=desc;
    	 this.code=status;
     }
     
     public int getCode() {
		return code;
	}
     
     public void setCode(int code) {
		this.code = code;
	}
     
     public void setDesc(String desc) {
		this.desc = desc;
	}
     
     public String getDesc() {
		return desc;
	}
    
}
