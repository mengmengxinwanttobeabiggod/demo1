package com.hsq.springboot.study.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(* com.hsq.springboot.study.service.impl..*.*(..))")
	public void executeService() {
	}

	@Before("executeService()")
	public void doBeforeAdvice(JoinPoint joinPoint) {
		System.out.println("--------doBeforeAdvice-----------");

	}

}
