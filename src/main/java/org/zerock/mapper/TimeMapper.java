package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
  
	@Select("SELECT now()")
	public String getTime();
	
	public String getTimes2();   //xml 에 쓴파일가져와서 객체완성해줌
}
