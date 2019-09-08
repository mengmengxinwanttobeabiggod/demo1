package com.hsq.springboot.study.dao;

import java.util.List;

import com.hsq.springboot.study.domain.City;
import com.hsq.springboot.study.domain.RQ_City;

public interface CityMapper {
   City getById(String  id);
   List<City> all(RQ_City rqity);
   int  deletebyId(Long id);
   
   int insert(City city);
   int update(City city);
}
