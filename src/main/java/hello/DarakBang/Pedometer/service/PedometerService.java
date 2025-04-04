package hello.DarakBang.Pedometer.service;

import hello.DarakBang.Pedometer.dto.PedometerDTO;
import hello.DarakBang.Pedometer.model.Pedometer;
import hello.DarakBang.Pedometer.repository.PedometerRepository;
import hello.DarakBang.community.model.Post;
import hello.DarakBang.login.model.Member;
import hello.DarakBang.login.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PedometerService {

    @Autowired
    private PedometerRepository pedometerRepository;
    @Autowired
    private MemberRepository memberRepository;

    public Pedometer createPedometer(PedometerDTO pedometerDTO){
        Pedometer pedometer = new Pedometer();
        pedometer.setSteps(pedometerDTO.getSteps());

        Member member = memberRepository.findById(pedometerDTO.getMemberId())
                .orElseThrow(() -> new RuntimeException("Post with ID " + pedometerDTO.getMemberId() + " not found"));
        pedometer.setMember(member);

        LocalDateTime now = LocalDateTime.now();
        pedometer.setRecordDate(now);

        return pedometerRepository.save(pedometer);
    }

}
