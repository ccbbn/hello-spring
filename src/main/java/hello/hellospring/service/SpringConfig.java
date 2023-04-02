package hello.hellospring.service;

import hello.hellospring.repository.*;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {


//    //h2연결
//    private DataSource dataSource;
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//////
//    //jpa버전 연결
//    private EntityManager em;
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }



    //springdata jpa

    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    // 스프링 빈에 등록
    @Bean
    public MemberService memberService() { return new MemberService(memberRepository);
    }  //memberRepository()


//   @Bean
//   public MemberRepository memberRepository() {
//        //return new MemoryMemberRepository();
////       return new JdbcMemberRepository(dataSource); //노가다
////       return new JdbcTemplateMemberRepository(dataSource); // 템플릿
//       return new JpaMemberRepository(em); // 템플릿
//    // 위에 서비스에 등록됨
//   }

}
