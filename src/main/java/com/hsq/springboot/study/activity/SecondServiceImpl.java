package com.hsq.springboot.study.activity;

import org.springframework.stereotype.Service;

@Service("secondservice")
public class SecondServiceImpl {
  
	public void print(String name)
	{
		System.out.println(name);
	}
}
