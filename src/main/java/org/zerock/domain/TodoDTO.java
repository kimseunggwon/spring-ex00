package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TodoDTO {
    //2개의 파라미터 값을 todoDTO가 가지고 있다
	private String title;
	private Date dueDate;
}
