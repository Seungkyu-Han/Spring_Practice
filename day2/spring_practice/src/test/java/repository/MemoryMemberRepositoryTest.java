package repository;

import domain.Member;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("seungkyu");

        repository.save(member);

        Member result = repository.findById(member.getStudentId()).get();

        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("seungkyu1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("seungkyu2");
        repository.save(member2);

        Member result1 = repository.findByName("seungkyu1").get();

        Assertions.assertEquals(member1, result1);

        Member result2 = repository.findByName("seungkyu2").get();

        Assertions.assertEquals(member2, result2);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("seungkyu1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("seungkyu2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertEquals(2, result.size());
    }
}
