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

	public Member createMember(MemberRequest request) {
		if(memberRepository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("사용할 수 없는 이메일입니다.");
		}
		Member member = request.toEntity();
		return memberRepository.save(member);
	}
}
