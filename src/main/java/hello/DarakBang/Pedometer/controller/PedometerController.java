package hello.DarakBang.Pedometer.controller;

import hello.DarakBang.Pedometer.dto.PedometerDTO;
import hello.DarakBang.Pedometer.model.Pedometer;
import hello.DarakBang.Pedometer.service.PedometerService;
import hello.DarakBang.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedometers")
public class PedometerController {

    @Autowired
    private PedometerService pedometerService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity<Pedometer> recordPedometer(@RequestBody PedometerDTO pedometerDTO, @RequestHeader("Authorization") String token){
        String userId = jwtUtil.extractUserId(token.substring(7)); // "Bearer " 제거 후, extractUserId 사용
        if (userId == null) {
            return ResponseEntity.status(401).build();
        }
        Pedometer pedometer = pedometerService.createPedometer(pedometerDTO);
        return ResponseEntity.ok(pedometer);
    }

}
