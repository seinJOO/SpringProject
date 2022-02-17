package com.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zerock.command.JoinVO;

@Service("joinService")
public class JoinServiceImpl implements JoinService {
	
	ArrayList<JoinVO> joinList = new ArrayList<JoinVO>();

	@Override
	public void memberJoin(JoinVO jvo) {
		joinList.add(jvo);
	}

	@Override
	public int idCheck(JoinVO jvo) {
		int result = 1;
		
		for (JoinVO dbvo : joinList) {
			if (dbvo.getId().equals(jvo.getId())) {
				result = 0;
			}
		}		
		return result;
	}
	
	@Override
	public JoinVO loginCheck(JoinVO jvo) {
		
		JoinVO vo = null;
		
		for (JoinVO dbvo : joinList) {
			if (dbvo.getId().equals(jvo.getId())) {
				String dbpw = dbvo.getPw();
				String upw = jvo.getPw();
				
				if (dbpw.equals(upw)) {
					return dbvo;
				}
			}
		}
		return vo;		
	}

}
