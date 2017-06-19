package edu.showcase.business.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
	@RequestMapping(value="/hello",method = RequestMethod.GET)
	public String HelloWorld(Model model){
		model.addAttribute("message", "Welcome to Spring MVC");
		return "hello3";
	}
	
	@RequestMapping(value="/hello2",method = RequestMethod.GET)
	public String HelloWorld2(Model model){
		model.addAttribute("message", "Welcome to Spring MVC");
		return "hello";
	}
	
	@RequestMapping(value = "/nodecorate/nodecorate", method = RequestMethod.GET)
	public String showNodecorate(Model model) {

		return "nodecorate/nodecorate";
	}
}
