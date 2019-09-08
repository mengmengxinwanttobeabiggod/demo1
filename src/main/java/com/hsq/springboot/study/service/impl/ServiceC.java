package com.hsq.springboot.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hsq.springboot.study.dao.CityMapper;
import com.hsq.springboot.study.domain.City;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
@Component
public class ServiceC {
	@Autowired
	private CityMapper mappper;

	void Insert(City city) {
		city.setId(3000l);
		city.setDescription("c");
		city.setProvinceId(1l);
		city.setCityName("yyyyy");
         mappper.insert(city);
	}
}
