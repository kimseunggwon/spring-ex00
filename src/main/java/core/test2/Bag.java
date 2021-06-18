package core.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("bag")   //다른 어플리케이션에 힌트를 주는 코드
@Component
public class Bag {

	private Book book; //가방이 북을 가지고 있다
	
	public Bag() {                         
		
	}
	
    @Autowired //자동 주입 (생성자를 통해서)
	public Bag(Book book) {
		this.book = book;
	}


	@Override //tostring 메소드 생성
	public String toString() { 
		return "Bag [book=" + book + "]";
	}
	
//	@Autowired //피라미터 자동 주입 (세터를 통해서)
	public void setBook(Book book) {
		this.book = book;
		
	}
}




















