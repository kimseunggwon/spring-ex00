package core.test3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class Hero {

	private Sword sword;
	
	@Qualifier ()   //특정 빈을 주입받겠다고 명시하는 어노테이션
	public void setSword(Sword sword) {
		this.sword = sword;
		
	}
	
}















