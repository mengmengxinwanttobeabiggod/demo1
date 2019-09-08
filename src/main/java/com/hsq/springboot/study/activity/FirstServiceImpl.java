package com.hsq.springboot.study.activity;

import org.springframework.stereotype.Service;

@Service("firstservice")
public class FirstServiceImpl {
  
	public String  getName(String name)
	{
		System.out.println(name);
		return name+",hsq";
	}
}
