package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/ex06/*")
public class Ex06Controller {
   
	@RequestMapping("/sub01")
	public String method01() {
		log.info("ex06, sub01 method");
		
            
		
		return "ex06/sub01";   // jsp파일로 리턴 지정해줄수있고 ,jsp 파일이 view가 된다
		                        // string 으로 리턴할경우 view 이름을 결정해준다.
		
		// WEB-INF/views/ex06-sub01.jsp 위에꺼랑 똑같은 경로
	}
	
	@RequestMapping("/sub02")
	public void method02() {
		
		log.info("ex06, sub02 method");
	}
	
	@RequestMapping("/sub03")
	public String method03() {
		log.info("ex06, sub03 method");
		
		return "forward:/ex06/sub02";     //view 이름으로 해석되는게 아님
		// sub03으로 포워드 한거니까
		// 주소창에 sub03이 남아있다      // forward 하나의 요청 처리
		                                 // redirect 2개의 요청 처리
	}
	
	@RequestMapping("/sub04")
	public String method04() {
		log.info("ex06,sub04 method");
		
		return "redirect:/ex06/sub02";      //redirect 2번째 요청 
		                                  //sub04 에서 sub02 로 가라고 요청한거니까
		                                  // 주소창에 sub02 가 남아있다
	}
}
























