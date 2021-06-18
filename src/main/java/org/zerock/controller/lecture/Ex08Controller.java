package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/ex08/*")
public class Ex08Controller {

	 @RequestMapping("/sub01")
	 public void method01(Model model) { //값으로 모델을 넣어줌
		 log.info("ex08, sub01 method"); //필요한 정보가 있으면 model에 넣어줌
		 
		 model.addAttribute("name","kim");
		 model.addAttribute("age",22);
	 }
	 
	 @RequestMapping("/sub02")
     public void method02(Model model) {
		 log.info("ex08, sub02 method");
		 
		 User user = new User();
		 user.setId("kkk");
		 user.setAge(22);
		 
		 model.addAttribute("user",user);
	 }
	 
	 @RequestMapping("/sub03")
	 public String method03(Model model) {
		 log.info("ex08, sub03 method");
		 
		 User user = new User(); //클래스명이 밑에 attribute 명으로 결정이됨
		 user.setId("korea");
		 user.setAge(777777);
		 
//		 model.addAttribute("user", user); 밑에랑 똑같은거  
		 model.addAttribute(user);
		 
		 return "ex08/sub02";
	 }
	 
	 // user id,age 를 다시 모델에 붙여주면. user 이름으로 꺼내면 user 값이 꺼내짐
	// http://localhost:8080/controller/ex08/sub04?id=kim&age=777
	 @RequestMapping("/sub04")
	 public String method04(User user, Model model) {
		 log.info("ex08, sub04 method"); 
		 
		 model.addAttribute("user", user);  //결국 user id,age 값이 들어가있음
		 
		 return "ex08/sub02";
  }
	 //http://localhost:8080/controller/ex08/sub05?id=ku&age=100000
	 @RequestMapping("/sub05")
	 public String method05(@ModelAttribute("user") User user, Model model) {
		 log.info("ex08, sub05 method");
		 
		 return "ex08/sub02";
	 }
	 
	//http://localhost:8080/controller/ex08/sub06?id=ggg&age=200000
		 @RequestMapping("/sub06")
		 public String method06(@ModelAttribute User user, Model model) {
			 log.info("ex08, sub06 method");
			 
			 return "ex08/sub02"; //attribute 이름을 생략하면 클래스명으로 들어감
  }
		 
		 @RequestMapping("/sub07")
		 public String method07( User user, Model model) { //model attribute 생략가능
			 log.info("ex08, sub07 method");
			 
			 model.addAttribute("hell world"); 
			 return "ex08/sub02"; 
  }
		 
		 @RequestMapping("/sub08")
		 public String method08(User user) { 
			 
			 log.info("ex08, sub08 method");
			 
			 return "ex08/sub02";
	 }
		 
		 //User user 가 객체, 빈이 아니면
         
		 
		 @RequestMapping("/sub09")
		 public void method09(@ModelAttribute("age") int age,
				 @ModelAttribute("name") String name) { //@requestParam 생략가능 
			 log.info("ex08, sub09 method");
			 
			 log.info(age);
			 log.info(name);
			 
		 }
}











