package spring_practice.spring_practice.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring_practice.spring_practice.domain.Member;
import spring_practice.spring_practice.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() throws Exception{
        //given
        Member member = new Member();
        member.setName("seungkyu");

        //when
        Long stuId = memberService.join(member);

        //then
        Member findMember = memberRepository.findById(stuId).get();
        Assertions.assertEquals(member, findMember);
    }

    void dupliExc() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("seungkyu");

        Member member2 = new Member();
        member2.setName("seungkyu");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertEquals(e.getMessage(), "이미 등록된 학생입니다.");
    }
}