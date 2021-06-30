package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
// 책 358 
public class SampleRestController {
     
	//책 359                                  요청
	@GetMapping(value="/getText", produces = "test/plain; charset=UTF-8")
	public String getText() {
		
		//       MIME TYPE 이란 파일변환이다(웹을통해 여러형태의 파일전달하는데 애쓰고있다)
		log.info("MIME TYPE :" + MediaType.TEXT_PLAIN);
		
		return "안녕하세요";
	}
	
	// 책 361
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE })
	public SampleVO getSampe() {
		
		return new SampleVO (11,"스타","로드");
	}
	//책 363
	@GetMapping("/getList")
	public List<SampleVO> getList() {
         
		List<SampleVO> list = new ArrayList<>();
		
		for(int i =1; i < 10; i++) {
			list.add(new SampleVO(i, i+"first", i+ "last"));
		}
	
	return list;
	
  }
	
	//챌 364
	@GetMapping("/getMap")
	public Map<String, SampleVO> getMap() {
		
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111,"그르투","주니어"));
		
		return map;
	}
	
	//책 365
	@GetMapping(value = "/check", params = {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		SampleVO vo = new SampleVO(0,""+height,"" + weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo); // responseentity로 객체를 생성할수있다
		}else{
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	// 책 366
	
	@RequestMapping("/product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat,
			@PathVariable("pid") String pid) {
		
		return new String[] { "category :" + cat,"productid: "+ pid};			
		}
				
	}













