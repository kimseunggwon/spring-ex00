package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {

	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
	//레스토랑 클래스에 셰프 클래스 만들어 놓은것을 지정한것이다
	
}











