package com.zerock.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zerock.command.ScoreVO;
import com.zerock.dao.ScoreDAO;


/*사실은... Component, Service, Repository 어노테이션의 기능은 같다!!
 	이름을 지정하지 않아도 잘 동작한다~~!! */
// 2) @Repository("ScoreService") - DB와 관련된 클래스와 주로 씀
// 3) @Service("ScoreService") - 해당 클래스를 컨테이너에 빈으로 생성하겠다는 어노테이션
// *) @Componentscan - 클래스 안에서 컴포넌트로 스캔을 할 수 있다
// @Autowired : 변수, 생성자, 세터 의존성 주입 가능 (타입->bean객체 이름->변수명)
// @Resource : 변수, 세터 의존성 주입 가능 (생성자는 주입 불가능) (bean객체 이름 ->변수명)

//DAO의 객체 주입은 일반적으로 Component나 Repository 어노테이션을 사용한다 !
//component-scan에 꼭 추가해준다


//1) 객체 생성을 통한 주입 : @Repository // = @Component
//2) DispatcherServlet에 bean객체 주입
//3) component자동 의존성 주입 - Autowired를 사용할 때는 서비스 어노테이션을 통해 해당 로직이 서비스임을 명시해야함!!!!!!!
@Service
public class ScoreServiceImpl implements ScoreService {
	
	// DAO를 사용하기	
	// 1) 객체 생성을 통한 주입 : ScoreDAO scoreDAO = new ScoreDAOImpl();
	// 2) bean객체 주입 : @Resource(name="ScoreDAO") private ScoreDAO scoreDAO;
	// 3) 자동 의존성 주입
	@Autowired
	private ScoreDAO scoreDAO;
	
	@Override
	public void scoreRegist(ScoreVO vo) {		
		scoreDAO.scoreInsert(vo);
	}
	
	@Override
	public ArrayList<ScoreVO> scoreResult() {		
		ArrayList<ScoreVO> DB = scoreDAO.scoreSelect();	// 점수 결과 메서드 호출		
		return DB;
	}
	
	@Override
	public void scoreDelete(String num) {
		scoreDAO.scoreDelete(num);
	}
	
	
	
/*		DAO 생성 전 처리
	ArrayList<ScoreVO> list = new ArrayList<ScoreVO>(); 

	@Override
	public void scoreRegist(ScoreVO dao) {
	
		
		System.out.println("----------- 서비스 계층 -----------");
		System.out.println(dao.getName());
		System.out.println(dao.getKor());
		System.out.println(dao.getEng());
		System.out.println(dao.getMath());
		
		list.add(dao);
		
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
*/
}
