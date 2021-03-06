package org.zerock.controller.lecture;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex07/*")
@Log4j
public class Ex07Controller {
	
	@RequestMapping("/sub01")
	public @ResponseBody String method01() {
		log.info("ex07, sub01 method");
		
		return "my response message!!!!!!!";
		
	}
	
	
	@RequestMapping("/sub02")
	public @ResponseBody String method02() {
		log.info("ex07, sub02 method");
		
		User user = new User();
		user.setId("donald");
		user.setAge(99);
		
		return user.toString();
	}
	
	@RequestMapping("/sub03")
	public @ResponseBody String method03() {
		log.info("ex07, sub03 method");
		
		User user = new User();
		user.setId("donald");
		user.setAge(99);
		
		return "{\"id\":" + "\"" + user.getId() + "\", " + "\"age\":" + user.getAge() + "}";
	}
	
	@RequestMapping("/sub04")
	public @ResponseBody User method04() {
		log.info("ex07, sub04 method");
		
		User user = new User();
		user.setId("trump");
		user.setAge(88);
		
		return user;
	}
	
	//헤더 + 본문 까지 넘기고 싶을때
	
	@RequestMapping("/sub05")
	public ResponseEntity<String> method05() {
		log.info("ex07, sub05 method");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","text/html; charset=utf-8");
		headers.add("my-header","my-vlaue");
		
		String body ="<h1>hello eey</h1>";
		
		// 상태 코드,값 (HttpStatus)
		//부가정보 (header)
		//본문 (body)
		
		return new ResponseEntity<String>(body,headers,HttpStatus.OK); 
	}
}
















