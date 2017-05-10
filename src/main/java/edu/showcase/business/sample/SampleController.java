package edu.showcase.business.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.showcase.business.sample.service.SampleService;
import edu.showcase.system.util.MessageUtil.MessageUtil;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
	
	@RequestMapping("/sample/getuser")
	public void getUser(@RequestParam Map<String,Object> paramMap) {
		
		List<?> user = sampleService.getUser();
		
		System.out.println("getUser");
		
	}
}
