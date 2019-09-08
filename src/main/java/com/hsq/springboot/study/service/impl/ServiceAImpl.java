package com.hsq.springboot.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hsq.springboot.study.dao.CityMapper;
import com.hsq.springboot.study.domain.City;
import com.hsq.springboot.study.service.ServiceA;
import com.hsq.springboot.study.service.ServiceB;
@Component
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class ServiceAImpl implements ServiceA {
   
	@Autowired
	private CityMapper mappper;
	@Autowired
	private ServiceB serviceB;
	@Autowired
	private ServiceC serviceC;
	
	@Override
	public void update(City city) {
		
		mappper.insert(city);
		
        try {
        	serviceB.insert(city);
		} catch (Exception e) {
			serviceC.Insert(city);
		}
	


		
	}

}
