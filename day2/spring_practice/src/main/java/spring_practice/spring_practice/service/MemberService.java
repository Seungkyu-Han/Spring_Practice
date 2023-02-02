package spring_practice.spring_practice.service;

import spring_practice.spring_practice.domain.Member;
import spring_practice.spring_practice.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    private void validateDuplicateMember(Member member){ // 같은 이름의 학생이 있는지 찾아주는 메서드
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 등록된 학생입니다.");
                });
    }

    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member); // 이미 등록된 학생이 아니면 저장
        return member.getStudentId();
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findStudent(Long studentId){
        return memberRepository.findById(studentId);
    }
}
