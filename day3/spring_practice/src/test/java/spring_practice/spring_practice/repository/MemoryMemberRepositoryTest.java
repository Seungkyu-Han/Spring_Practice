package spring_practice.spring_practice.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spring_practice.spring_practice.domain.Member;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member();
        member.setName("seungkyu");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getStudentId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("seungkyu1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("seungkyu2");
        repository.save(member2);

        //when
        Member result = repository.findByName("seungkyu1").get();

        //then
        Assertions.assertEquals(member1, result);
        Assertions.assertNotEquals(member2, result);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("seungkyu1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("seungkyu2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        Assertions.assertEquals(2, result.size());
    }
}