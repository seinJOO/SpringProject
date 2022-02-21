package com.zerock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zerock.command.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {


/*	root-context.xml에 히카리bean 설정이 없는 경우	
	private HikariConfig hikariConfig;
	private HikariDataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public BoardDAOImpl () {
		hikariConfig = new HikariConfig();		// 객체 생성(bean)
		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		hikariConfig.setUsername("myjsp");
		hikariConfig.setPassword("myjsp");
		
		dataSource = new HikariDataSource(hikariConfig);
		jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
	}
*/	

	// root-context.xml에서 설정 후 주입
/*		*/
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	@Override
	public void boardInsert(String name, String title, String content) {
		String sql = "INSERT INTO board01(name, title, content) VALUES(?,?,?)";		
		// sql 구문 실행 방법		
		// 1) PreparedStatement Setter생성 - 인자값으로 넣을 때 바로 메서드를 생성시켜서 처리할 수 있음 			
/*			int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {			
										@Override
										public void setValues(PreparedStatement ps) throws SQLException {
											ps.setString(1, name);
											ps.setString(2, title);
											ps.setString(3, content);
											
										}
									} );
			System.out.println("결과 조회 : 성공은 1, 실패는 0 : " + result);
*/			
		//*** 2) update() 메서드의 파라미터 값으로 update(sql문, ?에 바인딩할 값)
			int result = jdbcTemplate.update(sql, new Object[] {name, title, content});
			System.out.println(result);
		
	}

	@Override
	public ArrayList<BoardVO> boardSelect() {
/*		query()의 파라미터 의미
			- sql : sql쿼리, ?를 사용하는 preparedStatement용 쿼리를 사용
			- new Object[] {값, 값, ..} : sql 쿼리에 세팅할 값을 저장 (바인딩)
			- new RowMapper<Type>() : 조회 결과를 ResultSet으로부터 데이터를 읽어와 type 데이터 생성
					-> 익명클래스로 사용 = 인터페이스 / mapRow() 메서드는 ResultSet에서 읽어온 값을 처리한 후 리턴
*/		                
		String sql = "SELECT * FROM board01 ORDER BY num";
		List<BoardVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<BoardVO>() {
													@Override
													public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
														BoardVO vo = new BoardVO();
														vo.setNum(rs.getInt("num"));
														vo.setName(rs.getString("name"));
														vo.setTitle(rs.getString("title"));
														vo.setContent(rs.getString("content"));				
														return vo;				
													}
													});
		return (ArrayList<BoardVO>)list;
	}

	@Override
	public void boardDelete(String num) {
		String sql = "DELETE FROM board01 WHERE num = ?";
		int result = jdbcTemplate.update(sql, Integer.parseInt(num));
		System.out.println("삭제현황 : " + result);
		
	}
	
	
	
	
	
	
/* 		JDBC처리
 	1. 아티펙트 설치 (ojdbc8.jar) - mvnrepository.com에서 -> (pom.xml)
	2. DB 내에 board01 테이블 생성 (기본키 num을 sequence적용해서)
	3. DB 연결정보 생성
	4. 각 메소드별 처리


	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String user = "myjsp";
	private String password = "myjsp";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	@Override
	public void boardInsert(String name, String title, String content) {
		
		String sql = "INSERT INTO board01 (name, title, content) VALUES (?,?,?)";
		try {						
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}		
		//BoardVO vo = new BoardVO(name, title, content);DB.add(vo);
		
		
	}

	@Override
	public ArrayList<BoardVO> boardSelect() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "SELECT * FROM board01";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt("num"),rs.getString("name"),rs.getString("title"),rs.getString("content"));				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return list;
	}

	@Override
	public void boardDelete(String num) {
		String sql = "DELETE FROM board01 WHERE num = ?";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
	}
	*/

}
