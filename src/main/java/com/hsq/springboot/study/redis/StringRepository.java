package com.hsq.springboot.study.redis;

import java.util.concurrent.TimeUnit;

public interface StringRepository {
	<T extends Object> T find(String key);

	void set(String key, Object T);
	
	void set(String key, Object T,long duration);
	
	void set(String key,Object T,long duration ,TimeUnit timeUnit);

	void remove(String key);
	
	boolean exist(String key);
}