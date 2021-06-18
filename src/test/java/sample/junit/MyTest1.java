package sample.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyTest1 {

	@Test //test 메소드는 public void + 파라미터값이 없어여한다
	public void test() {
		// fail("Not yet implemented");  무조건 실패하는 메소드
		int i = 3;
		if ( i != 3) {
			fail("i는 3이 아닙니다.");
		}
	}
	
	@Test
	public void equals() {
		int i = 3;
		boolean b =true;
		Object c = null;
		
		assertEquals(i,3);
		assertEquals(b,true);
		assertTrue(b);
		assertNull(c);
	}
	
	@Test
	public void notequals() {
		int i = 5;
		boolean b = false;
		Object c = new Object();
		
		assertNotEquals(i,3);
		assertFalse(b);
		assertNotNull(c);
	}

}














