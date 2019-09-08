package com.hsq.springboot.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsq.springboot.study.dao.CityMapper;
import com.hsq.springboot.study.domain.City;
import com.hsq.springboot.study.domain.RQ_City;
import com.hsq.springboot.study.service.CityService;
@Service
@Transactional
public class CityServiceImpl implements CityService {
	@Autowired
    private CityMapper cityMapper;

	@Override
	@Cacheable(cacheNames="cityCached",unless="#result==null",key="#root.methodName") 
    public City getOne(String id) {
		City city = cityMapper.getById(id);
		return city;
	}

	@Override
	//@Cacheable(cacheNames="cityCached",unless="#result==null",key="#root.methodName")
	public List<City> all(RQ_City  rq) {
		return cityMapper.all(rq);
	}

	@Override
	public int deletebyId(long id) {
		return cityMapper.deletebyId(id);
	}
	

}
