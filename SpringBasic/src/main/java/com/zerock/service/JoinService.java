package com.zerock.service;



import java.util.ArrayList;

import com.zerock.command.JoinVO;

public interface JoinService {
	
	public void memberJoin(JoinVO jvo);
	public int idCheck(JoinVO jvo);
	public JoinVO loginCheck(JoinVO jvo);
	

}
