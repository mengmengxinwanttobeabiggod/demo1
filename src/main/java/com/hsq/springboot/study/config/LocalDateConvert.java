package com.hsq.springboot.study.config;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class LocalDateConvert implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(String source) {
		// TODO Auto-generated method stub
		if (StringUtils.isNotEmpty(source)) {
			DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
			return LocalDate.parse(source, formatter);
		} else {
			return null;
		}
	}

}
