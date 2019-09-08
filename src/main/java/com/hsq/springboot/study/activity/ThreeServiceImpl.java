package com.hsq.springboot.study.activity;

import org.springframework.stereotype.Component;

@Component("threeService")
public class ThreeServiceImpl {
  
	public void print(String content)
	{
		System.out.println(content);
	}
}
