package org.zerock.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")       //요청1
@Log4j
public class SampleController {
    
	@RequestMapping("")    //요청1받아서 일함 주소창에 '/sample/' 
	public void basic() {
		log.info("basic.................");
	}
	
	@RequestMapping(value="/basic", method = {RequestMethod.GET,RequestMethod.POST}) //주소에 basic 추가하면 일함
	public void basicGet() {
		log.info("basic get....................");
	}
	
	@GetMapping("/basicOnlyGet") //주소에 basicOnlyGey쓰면 일함
	public void basicGet2() {
		log.info("basic get only get..........");
	}
	
	@RequestMapping({"/basic3", "/basic4"}) //메소드가 여러개 처럼 값이 여러개 일 수도 있다
	public void basic3() {
		log.info("basic3, basic4.......");
	}
	
	// 131쪽
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name,
			@RequestParam("age") int age) {
		
		log.info("name:" + name);
		log.info("age:" + age);
		
		return "ex02";
	}
	
	//132p   http://localhost:8080/controller/sample/ex02List?ids=abc&ids=dwf == list로 abc,dwf 출력
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		 log.info("ids: " + ids);
		 
		 return "ex02List";
	}
	
	//133p   http://localhost:8080/controller/sample/ex02Array?ids=abc&ids=dwf == 배열로 abc,dwf 출력
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids : " + Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	//130쪽
	@GetMapping("/ex01")         //name ,age 
	public String ex01(SampleDTO dto) {
		log.info("" +dto);
		
		return "ex01";
	}
	
	//137쪽 ex03
	@GetMapping ("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo:" + todo);
		return "ex03";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	//144쪽
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05........");
	}
	
	//146쪽
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(77);
		dto.setName("권");
		
		return dto;
		
	}
	
	//148쪽
    @GetMapping("/ex07")  
	public ResponseEntity<String> ex07() {
		log.info("/ex07");
		
		// {"name":"권"}
		String msg ="{\name\":\"권\"}";
		
		HttpHeaders header = new HttpHeaders ();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	
    //140쪽
    //http://localhost:8080/controller/sample/ex04?name=kkkik&age=33&page=100000
    @GetMapping("/ex04")  
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
    	
    	log.info("dto: " + dto);  //sampleDTO 값 / 이름,나이
    	log.info("page: " + page); // primary 값 page 
    	
    	return "/sample/ex04";
    }
	
    
}








       
  
