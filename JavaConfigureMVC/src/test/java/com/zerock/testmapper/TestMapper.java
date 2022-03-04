package com.zerock.testmapper;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {
	
	@Select("SELECT SYSDATE FROM DUAL")		//xml을 만들지 않고 쓰는 방법
	public String getTime();
}
