package com.hsq.springboot.study.utils;

import java.io.IOException;
import java.util.stream.Stream;

import com.hsq.springboot.study.enums.BaseEnum;


public class EnumPackageScan {
	
	public static <T extends Enum> Class<T>[] doScan(String packageName) throws IOException{
		Class<?>[] classResource = EnumResourceLoader.getEnumResource(packageName);
		return fitlerEnums(classResource);
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends Enum> Class<T>[] fitlerEnums(Class<?>[] classResource)
	{
		return (Class<T>[]) Stream.of(classResource).filter
				(c->c.isEnum() && BaseEnum.class.isAssignableFrom(c))
				.toArray(length->new Class<?>[length]);
	}


	
}
