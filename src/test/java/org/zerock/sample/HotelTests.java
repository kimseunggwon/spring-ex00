package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j //롬록 제공 (로그 객체)
public class HotelTests {

	   @Setter(onMethod_ = @Autowired) //hotel객체를 주입 
       private SampleHotel hotel;
       
       @Test                //주입이 잘되어있으면 null이 아니다 
       public void testExist() {
    	   assertNotNull(hotel);
    	   
    	   log.info(hotel);
    	   log.info("--------------");
    	   log.info(hotel.getChef());
       }
}
