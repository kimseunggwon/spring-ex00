package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data      // VO = 객체 정보 역활  value object
public class BoardVO {

	private long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	
}












