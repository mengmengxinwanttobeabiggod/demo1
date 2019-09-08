package com.hsq.springboot.study.config;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class LocalTimeConvert implements Converter<String, LocalTime> {

	@Override
	public LocalTime convert(String source) {
		// TODO Auto-generated method stub
		if (StringUtils.isNotEmpty(source)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			return LocalTime.parse(source, formatter);
		} else {
			return null;
		}
	}

}
