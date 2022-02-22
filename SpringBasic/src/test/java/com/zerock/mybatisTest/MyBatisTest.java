package com.zerock.mybatisTest;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*	
	주로 개발 과정에서 DB연결을 위해 Test를 함
	src/test/java 폴더에는 자바클래스를 이용하여 여러 작업을 테스트할 용도로 사용됨
	실행은 Run as -> JUnitTest를 사용하여 실행
	@Test 어노테이션을 사용하여 테스트할 메서드를 지정
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisTest {

	// root-context.xml에 SqlSessionFactory 빈이 추가되었는지 확인 (의존성테스트)
	
	@Autowired
	SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() {
		System.out.println(">>>>>>>>>>>> sql팩토리 출력 : " + sqlFactory);
	}
}
