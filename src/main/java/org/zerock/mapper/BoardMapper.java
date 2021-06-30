package org.zerock.mapper;

import java.util.List;


import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

 // Mapper (DTO)
public interface BoardMapper {
	
//	@Select("SELECT * FROM tbl_board")
    public List<BoardVO> getList();
    
    public List<BoardVO> getListWithPaging(Criteria cri);
    
    
    // INSERT INTO tbl_board (title, content , writer)
    // VALUES (#{title}, #{content}, #{writer})
    public int insert(BoardVO board); 
    /* 예전 작성문
      
      String sql = "INSERT INTO tbl_board(title, content, writer) VALUES (?,?,?)";
      ...
      pstmt.setString( 1 , board.getTitle());
      pstmt.setString( 2 , board.getContent());
      pstmt.setString( 3 , board.getWriter());
      
      pstmt.executeUpdate();
     
     */
    
    public int insertSelectKey(BoardVO board); //인서트 + 키값 얻어오는거
    
    public BoardVO read(long bno);         // 하나의 레코드만 얻어오는거 
    
    public int delete(long bno);  //몇개 지웠는지 리턴
    
    public int update(BoardVO board);

    public int getTotalCount(Criteria cri);
}













