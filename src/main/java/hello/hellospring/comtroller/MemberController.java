package hello.hellospring.comtroller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 컨트롤러와 서비스를 자동으로 연결시켜줌 cmd + n -> Constructor
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
