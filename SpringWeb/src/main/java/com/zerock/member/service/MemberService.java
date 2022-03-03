package com.zerock.member.service;

import com.zerock.member.command.MemberVO;

public interface MemberService {

	public int checkId(String id);
   public int join(MemberVO vo);
   public int login(MemberVO vo);
      
}
