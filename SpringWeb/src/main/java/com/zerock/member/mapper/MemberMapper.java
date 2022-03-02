
package com.zerock.member.mapper;

import com.zerock.member.command.MemberVO;

public interface MemberMapper {
   
   public int join(MemberVO vo); // 회원가입
   public int login(MemberVO vo);
   
}
