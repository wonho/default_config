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

	@RequestMapping(value="/sample/pdf.do", method={RequestMethod.POST, RequestMethod.GET})
	
    public ModelAndView generatePDFreport(ModelAndView modelAndView) {

          Map<String,Object> parameterMap = new java.util.HashMap<String, Object>();

          List<testBo> usersList = new ArrayList();

          testBo user1 = new testBo();

          user1.setEML_ADDR("222");

          user1.setKOR_NME("한글이 깨지나");

          usersList.add(user1);

          testBo user2 = new testBo();

          user2.setEML_ADDR("333");

          user2.setKOR_NME("eeee");

          usersList.add(user2);
         

          testBo user3 = new testBo();

          user3.setEML_ADDR("333");

          user3.setKOR_NME("aaaaa");

          usersList.add(user3);

          JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

          parameterMap.put( "datasource", JRdataSource);

          //pdfReport bean has ben declared in the jasper-views.xml file

          modelAndView = new ModelAndView("pdfReport" , parameterMap);

          return modelAndView;

 }	
	
}
