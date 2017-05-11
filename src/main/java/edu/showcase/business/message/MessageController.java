package edu.showcase.business.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import edu.showcase.system.exception.BusinessException;
import junit.framework.Test;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	Logger logger = LoggerFactory.getLogger(MessageController.class);

//	@RequestMapping(value="/getxml",headers = "accept=application/json")
	@RequestMapping(value="/getxml")
	@ResponseBody
	public List<Map<String,Object>> getXml(@RequestBody Map<String, Object> dataHashMap) {
		
		logger.debug("{}",dataHashMap);

		Map<String,Object> dataMap = Maps.newHashMap();
		
		dataMap.put("cache1", "was1 cahced");
		dataMap.put("cache2", "was2 cahced");
		dataMap.put("cache3", "was3 cahced");
		
		List<Map<String,Object>> dataList = Lists.newArrayList();
		
		dataList.add(dataMap);
		
		return dataList;
	}
	
	@RequestMapping(value="/getjson")
	@ResponseBody
	public List<Map<String,Object>> getJson(@RequestParam("test") Map<String, Object> dataHashMap) {
		
		logger.debug("{}",dataHashMap);
		
		Map<String,Object> dataMap = Maps.newHashMap();
		
		dataMap.put("cache1", "was1 cahced");
		dataMap.put("cache2", "was2 cahced");
		dataMap.put("cache3", "was3 cahced");
		
		List<Map<String,Object>> dataList = Lists.newArrayList();
		
		dataList.add(dataMap);

		return dataList;
	}
	
	@RequestMapping(value="/getex")
	@ResponseBody
	public List<Map<String,Object>> getEx() {
		logger.debug("exception Test");
		throw new BusinessException("kkk");
	}	
}
