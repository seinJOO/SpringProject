package com.zerock.member.service;

import com.zerock.member.command.MemberVO;

public interface MemberService {

   public int join(MemberVO vo);
   public int login(MemberVO vo);
      
}
