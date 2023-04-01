package hello.hellospring.service;

import hello.hellospring.domain.repository.MemberRepository;
import hello.hellospring.domain.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {


    // 스프링 빈에 등록
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }


   @Bean
   public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    // 위에 서비스에 등록됨
   }

}
