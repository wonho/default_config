package edu.showcase.system.util.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.showcase.business.auth.LoginController;

public class LambdaTest {
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Test
	public void functionTest() throws Exception {
		
		Function<String,Map<String,String>> f = (x) -> {Map<String,String> b = new HashMap<>(); 
															b.put(x, x);
		                                                    return b; 
		                                                    };
		                                                    
		Map<String,String> apply = f.apply("aaaa");
		
		logger.info("{}",apply);
	}
	
	@Test
	public void predicateTest() throws Exception {
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("ba");
		list.add("ccc");
		
		
		list.removeIf(x->x.startsWith("c"));
		
		logger.info("{}",list);
	}
	
	public void display(Supplier<Integer>str) {		
		logger.info("{}",str.get());
	}
	
	@Test
	public void supplierTest() throws Exception {
		display(()->10);
	}
	
	public void display2(Integer i) {
		
	}
	
	@Test
	public void consumerTest() throws Exception {
		Consumer<Integer> consumer = x -> display2(x);
	}
	
	@Test
	public void unaryOperatorTest() throws Exception {
		 UnaryOperator<Integer> operator = v -> v * 100;

	     Function<Integer, Integer> function = v -> v * 100;

	     System.out.println(operator.apply(5));
	     System.out.println(function.apply(6));
	}
	
	

	
}
