package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Component      //component를 붙인 클래스는 자동으로 주입이 일어난다
@ToString
@Getter
public class SampleHotel {   // 샘플호텔 클래스,생성자 1개 
         private Chef chef;
         
      public SampleHotel(Chef chef) {  //생성자 는 chef값을 받음
    	  this.chef = chef;
      }
}
