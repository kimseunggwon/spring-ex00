package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;
import lombok.test.User;


@Controller
@RequestMapping("/ex03/*")
@Log4j
public class Ex03Controller {

	@RequestMapping("/sub01")
	public void method01(User user) { //파라미터 값 User 
		
		/*
		String id = request.getParameter("id");
	    String ageStr = request.getParameter("age");
	    int age = Integer.parseInt(ageStr);
		
		User user = new User();
		user.setId(id);               //알아서 형 변환까지 해서 넣어줌
		user.setAge(age);
		*/
		
		
		log.info("ex03, sub01 method");
		log.info(user);
		
	}
}
