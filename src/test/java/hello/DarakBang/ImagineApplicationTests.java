package hello.DarakBang;


import hello.DarakBang.attendance.service.AttendanceService;
import hello.DarakBang.login.model.Member;
import hello.DarakBang.login.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImagineApplicationTests {


    @Autowired
    private MemberService memberService;

    @Autowired
    private AttendanceService attendanceService;

    private Member testMember;

}
