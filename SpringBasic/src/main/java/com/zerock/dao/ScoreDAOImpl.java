package com.zerock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zerock.command.ScoreVO;

@Repository
public class ScoreDAOImpl implements ScoreDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void scoreInsert(ScoreVO vo) {
		
		String sql = "INSERT INTO score01(name, kor, eng, math) VALUES (?,?,?,?)";
		
		int result = jdbcTemplate.update(sql, new Object[] {vo.getName(),vo.getKor(),vo.getEng(),vo.getMath()});
		System.out.println("score삽입확인 : " + result);
	}

	@Override
	public ArrayList<ScoreVO> scoreSelect() {
/*
	query()의 파라미터 의미
	- sql
	- new Object[] {값, 값...}
	- new RowMapper<type>() : 조회결과 ResultSet으로부터 데이터를 읽어와 type데이터를 생성
		-> 익명 클래스로 사용 / mapRow() 메서드는 ResultSet에서 읽어온 값을 처리한 후에 리턴
		
		
*/		
		String sql = "SELECT * FROM score01 ORDER BY num";
		List<ScoreVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<ScoreVO>() {			
										@Override
										public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
											ScoreVO vo = new ScoreVO(); // 빈 객체 선언
											vo.setNum(rs.getInt("num"));
											vo.setName(rs.getString("name"));
											vo.setKor(rs.getString("kor"));
											vo.setEng(rs.getString("eng"));
											vo.setMath(rs.getString("math"));
											return vo;
										}
									});
		return (ArrayList<ScoreVO>) list;
	}

	@Override
	public void scoreDelete(String num) {
		String sql = "DELETE FROM score01 WHERE num = ?";
		int result = jdbcTemplate.update(sql, Integer.parseInt(num));
		System.out.println("삭제 확인 : " + result);
	}
	
	
	
	
	
/*	
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
*/

}
