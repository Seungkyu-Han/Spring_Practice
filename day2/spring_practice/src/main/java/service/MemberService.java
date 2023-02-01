package service;

import domain.Member;
import repository.MemberRepository;
import repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    //신입생 등록
    public Long join(Member member){
        memberRepository.save(member);
        return member.getStudentId();
    }

    //전체 학생 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
