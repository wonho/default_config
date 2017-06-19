package edu.showcase.business.sample;

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

import edu.showcase.business.message.MessageController;

@Controller
public class RestfulController {
	
	Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@RequestMapping(value="/getxy",headers = "accept=application/json")
	@ResponseBody
	public List<Map<String,Object>> getXml(@RequestParam Map<String, Object> dataHashMap) {
		
		logger.debug("{}",dataHashMap);

		Map<String,Object> dataMap = Maps.newHashMap();
		
		dataMap.put("cache1", "was1 cahced");
		dataMap.put("cache2", "was2 cahced");
		dataMap.put("cache3", "was3 cahced");
		
		List<Map<String,Object>> dataList = Lists.newArrayList();
		
		dataList.add(dataMap);
		
		return dataList;
	}
	

}
