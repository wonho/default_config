package edu.showcase.business.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.showcase.system.dao.CommonDao;

@Service
public class SampleService {

	@Autowired
	CommonDao dao;
	
	public void getX() {
		System.out.println("SampleService Print");
	}
	
	public List<?> getUser() {
		
		List<?> userList = dao.queryForList("user.select",  null);
		
		return userList;
		
	}


}
