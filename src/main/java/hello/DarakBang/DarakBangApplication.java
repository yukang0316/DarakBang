package hello.DarakBang;

import hello.DarakBang.login.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "hello.DarakBang")
public class DarakBangApplication {

    @Autowired
    private MemberService memberService;

    public static void main(String[] args) {
        SpringApplication.run(DarakBangApplication.class, args);
        System.out.println("애플리케이션 실행됨");
    }

}