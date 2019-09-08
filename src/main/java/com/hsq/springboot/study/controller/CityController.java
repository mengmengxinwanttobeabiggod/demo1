package com.hsq.springboot.study.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsq.springboot.study.domain.City;
import com.hsq.springboot.study.domain.RQ_City;
import com.hsq.springboot.study.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {
   
	@Autowired
	private CityService cityService;
	
	@GetMapping("{id}")
	public City getOne(@PathVariable String id)
	{   
		return cityService.getOne(id);
	}
	
	@RequestMapping(value="all")//,method=RequestMethod.POST
	public List<City> getAll(RQ_City rq){
        List<City> all = cityService.all(rq);
		return all;
	}
	
	@RequestMapping(value="alll",method=RequestMethod.POST)//,
	public List<City> gets(RQ_City rq)
	{    
        List<City> all = cityService.all(rq);
		return all;
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id,HttpServletResponse response)
	{   
		cityService.deletebyId(id);
		return ResponseEntity.ok("success");
	}
}
