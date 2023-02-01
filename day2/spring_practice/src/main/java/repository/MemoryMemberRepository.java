package repository;

import domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    public static Map<Long, Member> store = new HashMap<>(); //이곳에 일단 학생들을 저장
    public static long sequence = 0L; //key 값을 저장

    @Override
    public Member save(Member member) {
        member.setStudentId(++sequence); // 넘어온 member 의 학번을 sequence + 1로 set
        store.put(member.getStudentId(), member); // 학번을 넣어준 member 를 store 에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 만약 null 이라면 optional 로 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
