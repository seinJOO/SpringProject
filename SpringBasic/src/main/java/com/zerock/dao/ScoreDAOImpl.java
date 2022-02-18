package com.zerock.dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zerock.command.ScoreVO;

@Component
public class ScoreDAOImpl implements ScoreDAO {
	
	// DB연결 전이기 때문에 DB를 대신할 저장소 생성!
	
	ArrayList<ScoreVO> DB = new ArrayList<ScoreVO>();
	

	@Override
	public void scoreInsert(ScoreVO vo) {		// 점수 입력 메서드
		System.out.println("----------- 서비스 계층 -----------");
		System.out.println(vo.getName());
		System.out.println(vo.getKor());
		System.out.println(vo.getEng());
		System.out.println(vo.getMath());
		DB.add(vo);
	}

	@Override
	public ArrayList<ScoreVO> scoreSelect() {	// 점수 결과 출력 메서드		
		return DB;
	}

	@Override
	public void scoreDelete(String num) {		// 점수 삭제 메서드
		int index = Integer.parseInt(num);
		DB.remove(index);
	}

}
