package com.hsq.springboot.study.redis.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.hsq.springboot.study.redis.StringRepository;
@Service
public class StringRepositoryImpl implements StringRepository {

	@Autowired
	private RedisTemplate<Object,Object> template;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T find(String key) {
		// TODO Auto-generated method stub
		return (T) this.template.opsForValue().get(key);
	}

	@Override
	public void set(String key, Object T) {
		// TODO Auto-generated method stub
		 this.template.opsForValue().set(key, T);
	}

	@Override
	public void set(String key, Object T, long duration) {
		// TODO Auto-generated method stub
		 set(key,T,duration,TimeUnit.SECONDS);
	}

	@Override
	public void remove(String key) {
		// TODO Auto-generated method stub
		this.template.delete(key);
	}

	@Override
	public boolean exist(String key) {
		// TODO Auto-generated method stub
		return template.hasKey(key);
	}

	@Override
	public void set(String key, Object T, long duration, TimeUnit timeUnit) {
		// TODO Auto-generated method stub
		 this.template.opsForValue().set(key, T,duration,timeUnit);
	}

}
