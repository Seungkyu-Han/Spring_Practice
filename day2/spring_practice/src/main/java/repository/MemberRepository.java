package repository;

import domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //학생을 추가하는 방법
    Optional<Member> findById(Long id); //학번을 이용하여 학생을 찾는 방법
    Optional<Member> findByName(String name); //이름을 이용하여 학생을 찾는 방법
    List<Member> findAll(); //지금까지 저장된 학생을 LIST 로 받아오는 방법
}
