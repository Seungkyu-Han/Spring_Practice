package spring_practice.spring_practice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring_practice.spring_practice.domain.Member;
import spring_practice.spring_practice.repository.MemberRepository;

@SpringBootTest
@Transactional
class MemberServiceDBTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void join() throws Exception{
        //given
        Member member = new Member();
        member.setName("seungkyu");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberRepository.findById(saveId).get();
        Assertions.assertEquals(member.getName(), findMember.getName());
    }
}