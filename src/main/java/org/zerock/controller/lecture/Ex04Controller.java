package org.zerock.controller.lecture;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex04/*")
@Log4j
public class Ex04Controller {
    
	@RequestMapping("/sub01")
	public void method01(@RequestParam String date) {
		log.info("ex04, sub01 method");
		
		log.info(date);
	}
	
	@RequestMapping("/sub02")
	public void method02(@RequestParam Date date) {
	     log.info("ex04, sub02 method");
	     
	     log.info(date);
	}
	
	@InitBinder // 변환이 가능한 데이터는 자동으로 변환되지만
	            //상황에 따라 파라미터를 변환해서 처리해야 할 경우에 사용한다.
	public void initBinder(WebDataBinder binder) {
		log.info("init binder");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
}














