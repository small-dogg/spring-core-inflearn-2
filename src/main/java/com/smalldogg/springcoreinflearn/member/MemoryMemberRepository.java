package com.smalldogg.springcoreinflearn.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

  //동시성 이슈가 발생할 수 있기 때문에, 사실 HashMap이 아닌 ConcurrentHashMap을 사용하여 동시성 문제를 해결해야한다.
  private static Map<Long, Member> store = new HashMap<>();

  @Override
  public void save(Member member) {
    store.put(member.getId(), member);
  }

  @Override
  public Member findById(Long memberId) {
    return store.get(memberId);
  }
}
