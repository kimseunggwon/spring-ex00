package org.zerock.persistence;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.sample.HotelTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j //롬록 제공 (로그 객체)
public class DataSourceTests {

	@Setter(onMethod_= {@Autowired})
	private DataSource dataSource;
	
	
	@Test
	public void test() {
		assertNotNull(dataSource);
		
		try (Connection con = dataSource.getConnection()) {
			assertNotNull(con);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
