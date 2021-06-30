package org.zerock.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest01/*")
public class Ex01RestController {

	@RequestMapping("/sub01")
	@ResponseBody  
	public String method1() {
		
		return "/rest01/sub01";
	}
	
	@RequestMapping("/sub02")
	@ResponseBody
	public String method02() {
		return "hello world!";
	}
	
	@RequestMapping("/sub03")
	public String method3() {
		return "someViesName";
	}
}


















