package hello.hellospring.service;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    //h2연결
    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
////

    // 스프링 빈에 등록
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }


   @Bean
   public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
       return new JdbcMemberRepository(dataSource);
    // 위에 서비스에 등록됨
   }

}
