package com.sample.member;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	
	public Member getMember(Long id) {
		Optional<Member> optional = memberRepository.findById(id);
		
		if(optional.isEmpty()) {
			throw new RuntimeException("회원정보가 존재하지 않습니다.");
		}
		return optional.get();
	}
}
