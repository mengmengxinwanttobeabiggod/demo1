package com.hsq.springboot.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//Spring Boot 应用的标识
@MapperScan("com.hsq.springboot.study.dao")
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@EnableRedisRepositories
@EnableAspectJAutoProxy
public class AppConfig {
   
	 public static void main(String[] args) {
	        // 程序启动入口
	        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
	        SpringApplication.run(AppConfig.class,args);
	    }
}
