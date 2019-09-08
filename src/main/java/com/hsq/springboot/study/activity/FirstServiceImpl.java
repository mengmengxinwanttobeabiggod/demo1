package com.hsq.springboot.study.activity;

import org.springframework.stereotype.Service;

@Service("firstservice")
public class FirstServiceImpl {
  
	public String  getName(String name)
	{
		System.out.println(name);
		System.out.println("git 1");
		return name+",hsq";
	}
}
