package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // 테스트할 때 쓴 데이터를 끝나고 날려버림, test를 계속 반복할 수 있음
class MemberServiceIntegrationTest {
    // 일반 저장
//    MemberService memberService;
//    MemoryMemberRepository memberRepository;
//

//    @BeforeEach // DI작업,
//    public void beforeEach() {
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);
//    }
//@AfterEach
//public void afterEach() {
//    memberRepository.clearStore();
//}

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;




    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long savedId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(savedId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
//        assertThrows(IllegalStateException.class,  () -> memberService.join(member2));
        IllegalStateException e = assertThrows(IllegalStateException.class,  () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미존재");
        //        try {
//            memberService.join(member2);
//            fail("예외가 발생해야 합니다");
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미존재");
//
//        }
    }

}