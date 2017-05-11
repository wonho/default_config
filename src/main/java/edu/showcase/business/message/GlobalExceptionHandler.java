package edu.showcase.business.message;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.common.collect.Maps;

import edu.showcase.system.exception.BusinessException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public Map<String,Object> BusinessExceptionHandler(BusinessException ex) {
	Map<String,Object> dataMap = Maps.newHashMap();
		
		dataMap.put("Exception1", "Business Exception1");
		dataMap.put("Exception2", "Business Exception2");
		dataMap.put("Exception3", "Business Exception3");
		
		System.out.println("global business Exception");
		
		return dataMap;
	}
}
