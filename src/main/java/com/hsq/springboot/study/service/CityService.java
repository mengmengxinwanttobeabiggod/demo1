package com.hsq.springboot.study.service;

import java.util.List;

import com.hsq.springboot.study.domain.City;
import com.hsq.springboot.study.domain.RQ_City;

public interface CityService {
    City getOne(String id);
    
    List<City> all(RQ_City rq);
    
    int  deletebyId(long id);
}
