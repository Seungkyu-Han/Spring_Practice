package spring_practice.spring_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_practice.spring_practice.repository.JdbcMemberRepository;
import spring_practice.spring_practice.repository.JdbcTemplateMemberRepository;
import spring_practice.spring_practice.repository.MemberRepository;
import spring_practice.spring_practice.repository.MemoryMemberRepository;
import spring_practice.spring_practice.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class StudentConfig {

    private final DataSource dataSource;

    public StudentConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
