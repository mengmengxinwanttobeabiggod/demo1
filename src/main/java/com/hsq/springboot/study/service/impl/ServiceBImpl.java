package com.hsq.springboot.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hsq.springboot.study.dao.CityMapper;
import com.hsq.springboot.study.domain.City;
import com.hsq.springboot.study.service.ServiceB;
@Component
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.NESTED)
public class ServiceBImpl implements ServiceB {
   
	@Autowired
	private CityMapper mappper;
	@Override
	public void insert(City city) {

		city.setId(2000l);
		city.setDescription("RRRRRRRR");
		city.setCityName("wB");
		mappper.insert(city);
		throw new RuntimeException();
    }

}
