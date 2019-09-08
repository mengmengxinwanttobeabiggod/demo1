package com.hsq.springboot.study.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;


public class EnumResourceLoader {

	private static String resourcePattern = "**/*.class";
	private static String suffixClass = ".class";
	private static Map<String, Class<?>[]> cache = new HashMap<>();
	private static final Logger log = LoggerFactory.getLogger(EnumResourceLoader.class);

	public static Class<?>[] getEnumResource(String basePackage) throws IOException {
		String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + resolveBasePackage(basePackage)
				+ '/' + resourcePattern;
		log.info("扫描枚举包路径:{}", packageSearchPath);
		
		if (!cache.containsKey(packageSearchPath)) {
			Resource[] resource = getResource(packageSearchPath);
			Arrays.stream(resource).forEach(r->{
				log.info(r.getClass().getName());
				log.info(r.getFilename());
			});
			log.info("扫描出资源数:{}",resource.length);
			Class<?>[] classResource = getClassResource(basePackage, resource);
			log.info("扫描出Class资源数:{}",classResource.length);

			cache.put(packageSearchPath, classResource);
		}
		return cache.get(packageSearchPath);
	}

	private static String resolveBasePackage(String locationPath) {
		// TODO Auto-generated method stub
//		return wildcard + "/" + locationPath.replace(".", "/");
		return locationPath.replace(".", "/");
	}

	private static Resource[] getResource(String locationPath) throws IOException {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		return resolver.getResources(locationPath);
	}

	private static Class<?>[] getClassResource(String basePackage, Resource[] resource) {
		return Arrays.stream(resource).map(c -> {
			try {
				log.info("扫描出资源文件:{}",c.getFilename());
				int suffixClassIndex = c.getFilename().lastIndexOf(suffixClass);
				String fileName = c.getFilename().substring(0, suffixClassIndex);
				return Class.forName(basePackage + "." + fileName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}).toArray(length -> new Class<?>[length]);
	}

}
