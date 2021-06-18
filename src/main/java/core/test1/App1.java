package core.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
	public static void main(String[] args) {
       System.out.println("프로그램 실행1");
		
       // Desk desk = new Desk();
       
       String path = "core/test1/core-test1.xml";
       ApplicationContext context = new ClassPathXmlApplicationContext(path); //위 경로에 있는 설명서를 읽어서 꺼내쓸 빈을 찾는다 (객체를 만든다)
                                                                              // 그리고 빈 주입된다
       Object o = context.getBean("desk"); //xml에서 만든 필요한 객체를 꺼내서 쓴거
       System.out.println(o);              // xml 객체가 주입이 된거다
       
       Object o2 = context.getBean("leg");
       System.out.println(o2);
       
       Object o3 = context.getBean("chair"); //생성자를 통해서도 주입할 수 있다
       System.out.println(o3);
       
	}
}
