package edu.showcase.business.sample;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.showcase.system.util.MessageUtil.MessageUtil;

@Controller
public class SampleController {

	@Autowired
	SampleService sampleService;
	
	@Autowired
	MessageUtil messageUtilService;
	
	@RequestMapping("/sample/get")
	public void getX(@RequestParam Map<String,Object> paramMap) {
		System.out.println("helum......");
		
		System.out.println(messageUtilService.getMessage("exception.DataIntegrityViolationException"));
		
		sampleService.getX();
		
	}
}
