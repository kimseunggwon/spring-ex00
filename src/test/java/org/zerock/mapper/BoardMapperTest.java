package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.TimeMapperTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j //롬록 제공 (로그 객체)
public class BoardMapperTest {
	
	@Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		assertNotNull(mapper); //notnull 일때 list를 불러온다 라는뜻
		
		List<BoardVO> list = mapper.getList();
		
//		assertEquals(5, list.size());
		assertTrue(list.size() > 0);
		
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		int cnt = mapper.insert(board);
		
		assertEquals(1, cnt);
	}
	
	public void testInsertSelectKey() { //insertselectkey는 db에 명령을 한번만 보내며
		BoardVO board = new BoardVO();  // 우선 입력한 결과값을 다음 쿼리로 바로 return 시켜주는것
		board.setTitle("새로 작성하는 글12");
		board.setContent("새로 작성한느 내용12");
		board.setWriter("newbie12");
		
		assertEquals(0, board.getBno());
		
		int cnt = mapper.insertSelectKey(board);
		
		assertEquals(1, cnt);
		assertNotEquals(0, board.getBno());
		
	}
	
	@Test
	public void testRead() {
		BoardVO vo = mapper.read(1);
		
		assertNotNull(vo);
		assertEquals(1, vo.getBno());
		
		/* insert, 자동 증가 키값 확인 */
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성한느 내용");
		board.setWriter("newbie");
		
		// COUNT
		int cnt = mapper.insertSelectKey(board); //insert 한다음에 키를 얻어오는게 insertselectkey가 하는일이다
		
		long key = board.getBno(); //키로 읽어왔을때
		
		BoardVO newBoard = mapper.read(key);
		

		assertNotNull(newBoard); // 키가 존재하는가 ?
		assertEquals(key, newBoard.getBno());
		
	}	
	
	@Test
	public void testDelete() {
		int cnt = mapper.delete(0);  //게시물 번호 0번을 삭제
		
		assertEquals(0, cnt);   //처음 지울때는 있으니까 지워지는게 맞다
		
//		cnt = mapper.delete(13);
//		assertEquals(1,cnt);

		BoardVO board = new BoardVO();
		board.setTitle("title");
		board.setContent("content");
		board.setWriter("writer");
	
		
		mapper.insertSelectKey(board); //지우기전에 insert를 했으니까
		
		cnt = mapper.delete(board.getBno()); //지울수 있다
		assertEquals(1, cnt);
	}
	
	@Test
	public void testUpdate() {
		long bno = 1; //5번째 업데이트 할거라고 지정
		
		BoardVO board = new BoardVO();
		board.setBno(bno);       // 5번째 내용 변경
		board.setTitle("new title");
		board.setContent("new content");
		board.setWriter("user00");
		
		int cnt = mapper.update(board);
		
		assertEquals(1,cnt);
		
		BoardVO board5 = mapper.read(bno); //위에서 5번으로 바꿧으니까 5번 바뀐내용이 equal 맞는지 확인하는거
		assertEquals(board.getTitle(), board5.getTitle());   
		assertEquals(board.getContent(), board5.getContent());
		assertEquals(board.getWriter(), board5.getWriter());
		
	}	
	
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		assertEquals(10, list.size());
		
	}
}









