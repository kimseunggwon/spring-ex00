package core.test3;

import org.apache.ibatis.javassist.ClassClassPath;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FireSword implements Sword{

	 public static void main(String[] args) {
		 String path = "core/test3/core-test3.xml";
		 ApplicationContextt context = new ClassClassPathXmlApplicationContext(path);
		 
		 System.out.println("프로그램 종료");
	 }
}
