package lombok.test;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

//lombok 은 원하는 메소드를 바로 만들수있다
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor //final 필드만 받아내는 생성자만듬
public class Desk {
      private final double price;
      private final String model;
      private  String name;
}
