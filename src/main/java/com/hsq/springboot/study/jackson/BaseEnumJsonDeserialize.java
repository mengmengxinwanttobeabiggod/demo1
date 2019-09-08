package com.hsq.springboot.study.jackson;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ClassUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import com.hsq.springboot.study.enums.BaseEnum;
import com.hsq.springboot.study.utils.EnumPackageScan;


/**
 * BaseEnum json反序列化工厂
 * 
 *
 */
@Configuration
public class BaseEnumJsonDeserialize {

	private static Map<Class<? extends Enum<?>>, Map<Integer, Enum<?>>> cache = new HashMap<>();

	/**
	 * 根据enum.class,code获取实例
	 * 
	 * @param classz
	 *            class
	 * @param code
	 *            BaseEnum.getCode
	 * @return BaseEnum
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Enum<?>> T factory(Class<T> classz, int code) {
		return (T) cache.get(classz).get(code);
	}

	// 将BaseEnum的class做为Key,enumConstants做为value放入map
	private static <T extends Enum<?>> void putCache(Class<T> t, T[] enums) {
		if (!cache.containsKey(t)) {
			cache.put(t, getEnumConstants(enums));
		}
	}

	// 将EnumConstants的所有实例，以code为key，对象为Value，放入map，并返回map
	private static <T extends Enum<?>> Map<Integer, Enum<?>> getEnumConstants(T[] enums) {
		Map<Integer, Enum<?>> map = new HashMap<>();
		for (T obj : enums) {
			map.put(((BaseEnum)obj).getCode(), obj);
		}
		return map;
	}

	/**
	 * 将classz枚举的所有实例放入cache
	 * 
	 * @param classz
	 */
	public static <T extends Enum<?>> void putCache(Class<T> classz) {
		System.out.println("loader enum to cache: "+classz);
		Assert.isAssignable(BaseEnum.class, classz);
		putCache(classz, classz.getEnumConstants());
	}
	public BaseEnumJsonDeserialize(){
		String basePackage = ClassUtils.getPackageName(BaseEnum.class);
		try {
			Arrays.stream(EnumPackageScan.doScan(basePackage))
			.forEach(u->putCache(u));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
