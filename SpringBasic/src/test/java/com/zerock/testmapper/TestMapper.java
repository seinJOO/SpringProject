package com.zerock.testmapper;

import java.util.ArrayList;
import java.util.Map;

import com.zerock.command.ScoreVO;

public interface TestMapper {
	
	// 추상 인터페이스 - 매퍼가 찾아갈 경로
	
	public String getTime();	// 서버시간 알아오기
	public ArrayList<ScoreVO> select();		//	값은 불러오면 되기 때문에 인자값은 없다~!
	public boolean insert(ScoreVO vo);		// 인자값으로 key-value로 매핑된 hashmap을 설정할 수 있다
	public boolean insert2(Map<String, String> map);
}
