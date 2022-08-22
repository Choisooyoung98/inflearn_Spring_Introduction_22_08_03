package hello.hellospring;

import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링빈에 AutoWise 하지않고 직접 연결시켜주는 것
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean // 스프링 데이터 jpa는 memberRepository 인젝션을 알아서 받아와서 등록해준다.
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /*@Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }*/
}
