package com.smalldogg.springcoreinflearn.member;

public interface MemberService {

  void join(Member member);

  Member findMember(Long memberId);
}
