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
@Log4j
public class SampleTests {
	
        @Setter(onMethod_ = {@Autowired}) 
        private Restaurant restaurant;      
        
        //세터를 통해서 레스토랑 객체를 샘플 테스트에 지정(만든)한것이다
        /*
         @Autowired
         public void setRestaurant(Restaurant restaurant) {
           this.restaurant = restaurant;
         */
        
        
        @Test                   //테스트를 통해 레스토랑 객체가 들어왔는지 확인
        public void testExist() {
 //       	System.out.println(restaurant);
        	assertNotNull(restaurant);
        	
        	log.info(restaurant);
        	log.info("-------------------------");
        	log.info(restaurant.getClass());
        	
        }
	
}
