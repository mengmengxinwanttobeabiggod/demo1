package com.hsq.springboot.study.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


//@Configuration
public class RedisConfig extends CachingConfigurerSupport {
	/**
	 * <!-- SDR默认采用的序列化策略有两种，一种是String的序列化策略，一种是JDK的序列化策略。
	 * StringRedisTemplate默认采用的是String的序列化策略，保存的key和value都是采用此策略序列化保存的。
	 * RedisTemplate默认采用的是JDK的序列化策略，保存的key和value都是采用此策略序列化保存的。
	 * 就是因为序列化策略的不同，即使是同一个key用不同的Template去序列化，结果是不同的。所以根据key去删除数据的时候就出现了删除失败的问题。
	 * --> <!-- redis 序列化策略 ，通常情况下key值采用String序列化策略， --> <!--
	 * 如果不指定序列化策略，StringRedisTemplate的key和value都将采用String序列化策略； --> <!--
	 * 但是RedisTemplate的key和value都将采用JDK序列化
	 * 这样就会出现采用不同template保存的数据不能用同一个template删除的问题 -->
	 **/
	@Bean("redisTemplate")
	@ConditionalOnMissingBean(RedisTemplate.class)
	public RedisTemplate<Object, Object> redisredisTemplate(@Autowired RedisConnectionFactory connectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		//redisTemplate.setDefaultSerializer(new StringRedisSerializer());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		//redisTemplate.setValueSerializer(new StringRedisSerializer());  //不能随便设置 不然pojo不能转为strig
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}

	// 缓存管理器
	@Bean
	public CacheManager cacheManager(@Autowired RedisTemplate redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		// 设置缓存过期时间 默认是永不过期
		cacheManager.setDefaultExpiration(10000);
		return cacheManager;
	}
}
