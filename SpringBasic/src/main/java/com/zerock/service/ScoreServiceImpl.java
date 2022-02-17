package com.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zerock.command.ScoreVO;


/*사실은... Component, Service, Repository 어노테이션의 기능은 같다!!
 	이름을 지정하지 않아도 잘 동작한다~~!! */
// 2) @Repository("ScoreService") - DB와 관련된 클래스와 주로 씀
// 3) @Service("ScoreService") - 해당 클래스를 컨테이너에 빈으로 생성하겠다는 어노테이션
@Component	// 어노테이션으로 스캔을 하는 방법!
public class ScoreServiceImpl implements ScoreService {
	
	ArrayList<ScoreVO> list = new ArrayList<ScoreVO>(); 

	@Override
	public void scoreRegist(ScoreVO vo) {
		
		System.out.println("----------- 서비스 계층 -----------");
		System.out.println(vo.getName());
		System.out.println(vo.getKor());
		System.out.println(vo.getEng());
		System.out.println(vo.getMath());
		
		list.add(vo);
		
		System.out.println(list.toString());
		
	}

	@Override
	public ArrayList<ScoreVO> scoreResult() {
		return list;
	}

	@Override
	public void scoreDelete(String num) {
		int index = Integer.parseInt(num);
		list.remove(index);
	}

}
