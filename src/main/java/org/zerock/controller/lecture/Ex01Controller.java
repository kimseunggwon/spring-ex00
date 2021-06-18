package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller //컨트롤러 라는것을 명시해줘야 한다
@RequestMapping("/ex01/*")   //어느경로인지 명시
@Log4j // 로그 제공 sout 대신에
public class Ex01Controller { //객체를 만들 수 있는 클래스가 완성
    
	@RequestMapping("/sub01")
	public void method01() {
//		System.out.println("ex01, sub01 method");
		log.info("ex01,sub01 method");
		
	}
	
	@RequestMapping("/sub02")
	public void method02() {
		log.info("ex01, sub02 method");
	}
	
	@RequestMapping(value = "/sub03", method = RequestMethod.GET)  //get방식으로 일할때
    public void method03() {
    	log.info("ex01,sub03 get method");
    }
	
	@RequestMapping(value="/sub03", method= RequestMethod.POST) //post방식으로
	public void method04() {
       log.info("ex01, sub03 post method");	
	}
	
	@GetMapping  ("/sub05") //request 맵핑인데 get와 조합
	public void method05() {
		log.info("ex01, sub05 get method");
	}
	
	@PostMapping ("/sub06") //request 맵핑인데와 post 조합
	public void method06() {
		log.info("ex01, sub06 post method");
	 // 
	}
}













