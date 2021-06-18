package org.zerock.persistence;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j //롬록 제공 (로그 객체)
public class TimeMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		assertNotNull(timeMapper);
		
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
	
	public void testGetTime2() {
		assertNotNull(timeMapper);
		assertNotNull(timeMapper.getTimes2());
		
		log.info(timeMapper.getTimes2());
	}
}




