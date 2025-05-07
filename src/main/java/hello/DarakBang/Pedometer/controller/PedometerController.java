package hello.DarakBang.Pedometer.controller;

import hello.DarakBang.Pedometer.dto.PedometerDTO;
import hello.DarakBang.Pedometer.model.Pedometer;
import hello.DarakBang.Pedometer.service.PedometerService;
import hello.DarakBang.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedometers")
public class PedometerController {

    @Autowired
    private PedometerService pedometerService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<Pedometer> recordPedometer(
            @RequestBody PedometerDTO pedometerDTO,
            @RequestHeader("Authorization") String token) {

        String userId = jwtUtil.extractUserId(token.substring(7)); // "Bearer " 제거

        if (userId == null) {
            return ResponseEntity.status(401).build();
        }

        // userId를 pedometerDTO에 세팅하거나 검증 로직 추가 가능
        Pedometer pedometer = pedometerService.createPedometer(pedometerDTO);
        return ResponseEntity.ok(pedometer);
    }
}