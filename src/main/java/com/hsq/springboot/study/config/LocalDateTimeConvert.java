package com.hsq.springboot.study.config;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;;
public class LocalDateTimeConvert implements Converter<String,LocalDateTime>{
	private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE; 
	private static final DateTimeFormatter formatter1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME; 
	private static final DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	private static final  DateTimeFormatter DATEFORMATTER = new DateTimeFormatterBuilder().append(formatter)
			    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
			    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
			    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
			    .toFormatter();
	
	@Override
	public LocalDateTime convert(String source) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotEmpty(source)){
			if(source.length() > 10){
				//如果 字符串  不含有 "T" 则 formatter3转化  否则  用formatter1
				if(! source.contains("T"))
				{
				    return LocalDateTime.parse(source,formatter3);
				}else {
					return  LocalDateTime.parse(source,formatter1);
				}
			}else{
				return LocalDateTime.parse(source, DATEFORMATTER);
			}
		}else{
			return null;
		}
		
	}

}
