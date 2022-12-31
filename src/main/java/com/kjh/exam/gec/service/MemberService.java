package com.kjh.exam.gec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjh.exam.gec.repository.MemberRepository;
import com.kjh.exam.gec.vo.Member;

@Service
public class MemberService {
	
	private MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public int doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNum, String email) {
		
		Member existsMember = getMemberByLoginId(loginId);
		
		if(existsMember != null) {
			return -1;
		}

		existsMember = getMemberByNameAndEmail(name, email);
		
		if(existsMember != null) {
			return -2;
		}
		
		memberRepository.doJoin(loginId, loginPw, name, nickname, cellphoneNum, email);
		return memberRepository.getLastInsertId();
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}
	
	private Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}
	
	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
	}
	
}
