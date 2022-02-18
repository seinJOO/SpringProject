package com.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.zerock.command.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	
	
	
/* 		JDBC처리
 	1. 아티펙트 설치 (ojdbc8.jar) - mvnrepository.com에서 -> (pom.xml)
	2. DB 내에 board01 테이블 생성 (기본키 num을 sequence적용해서)
	3. DB 연결정보 생성
	4. 각 메소드별 처리

*/
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

}
