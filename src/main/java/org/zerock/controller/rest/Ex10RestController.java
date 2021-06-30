package org.zerock.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/rest10")
@Log4j
public class Ex10RestController {     //DB까지 안가고 USER 추가해서 JSP에 출력하기
	private List<User> list = new ArrayList<>();
	private int like = 10;
	
	@PostMapping("/add")
	public User addUser(User user) {
		
		list.add(user);
		
		log.info(list);
		
		return user;
	}
	
	@GetMapping("/list")
	public List<User> list() {
		return list;           //user list 리턴해줘서 --> jsp 
	}
	
	@PostMapping("/like")
	public Integer like() {
		like++;
		
		return like;
	}
	
	@PostMapping("/dislike")
	public Integer dislike() {
		like--;
		
		return like;
	}
}













