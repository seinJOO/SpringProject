
package com.zerock.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.member.command.MemberVO;
import com.zerock.member.mapper.MemberMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

   
   @Autowired // mybatis 매퍼를 추가
   MemberMapper mapper;
   
   @Override
   public int join(MemberVO vo) {
      // mapper를 생성 (MemberMapper)한 후에 DB와 마이바티스로 연동처리
      // 처리된 결과를 확인 반환값으로 넘김.
      // 마이바티스는 root-context.xml에서 xml스캔처리해야 함.
      // xml에는 쿼리에 대한 내용이 정리되어야 한다.
	   int result = mapper.join(vo);
      return result;
   }

	@Override
	public int login(MemberVO vo) {
		if (mapper.login(vo) == 0) {
			return 0;
		} else return 1;
	}

	@Override
	public int checkId(String id) {
		int result = mapper.checkId(id);
		return result;
	}
}

