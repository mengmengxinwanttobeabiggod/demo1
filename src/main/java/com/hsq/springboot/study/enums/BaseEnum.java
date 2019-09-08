/**
 * 
 */
package com.hsq.springboot.study.enums;

import org.springframework.util.Assert;

import com.hsq.springboot.study.jackson.BaseEnumJsonDeserialize;


/**
 * @author jiangdelai
 *
 */
@FunctionalInterface
public interface BaseEnum{
	int getCode();
	static <T  extends Enum<?>> T factory(Class<T> targetType, int code) {
		Assert.isAssignable(BaseEnum.class, targetType);
		return (T) BaseEnumJsonDeserialize.factory(targetType, code);
	}


}
