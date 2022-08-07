package hello.hellospring.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        model.addAttribute("data2","hello!!!!!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // url에서 hello-mvc 라는 값을 입력 받으면
    public String helloMvc(@RequestParam(value = "name", defaultValue = "default값") String name, Model model) { //외부에서 name이라는 파라미터를 받는다, 값이 없으면 defaultValue 리턴
        model.addAttribute("name", name); // 앞에 Key, 뒤에 값
        return "hello-templete"; // hello-templete.html 에 리턴한다.
    }

    @GetMapping("hello-string")
    @ResponseBody // html 태그 없이 문자만 그대로 리턴해준다.
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); // Hello 객체 생성
        hello.setName(name); // hello 객체에 name 입력
        return hello; // hello 객체를 넘김 -> json 으로 변환해서 출력
    }

    static class Hello {
        public String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
