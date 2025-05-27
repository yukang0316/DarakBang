package hello.DarakBang.Counsel.controller;

import hello.DarakBang.Counsel.service.CounselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/counsel")
@CrossOrigin(origins = "http://localhost:5001")
public class CounselController {

    @Autowired
    private CounselService counselService;

    @PostMapping("/chat")
    public ResponseEntity<?> chatWithModel(@RequestBody Map<String, Object> request) {
        RestTemplate restTemplate = new RestTemplate();
        //flask 서버 연동
        String flaskUrl = "http://172.31.33.32:5001/chat";

        try {
            // Flask API에 POST 요청 보내기
            ResponseEntity<Map> response = restTemplate.postForEntity(flaskUrl, request, Map.class);

            // 응답 상태 코드 확인
            if (!response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Flask 서버에서 오류 발생: " + response.getStatusCode());
                return ResponseEntity.status(500).body("Flask 서버 오류 발생");
            }

            // 응답 Body 확인
            if (response.getBody() == null) {
                System.out.println("Flask 응답이 비어있습니다.");
                return ResponseEntity.status(500).body("Flask 응답이 비어있습니다.");
            }

            // Flask 응답에서 question과 answer 추출
            String question = (String) request.get("question");
            String answer = (String) response.getBody().get("answer");

            if (answer == null) {
                System.out.println("Flask 응답에 answer 값이 없습니다.");
                return ResponseEntity.status(500).body("Flask 응답에 answer 값이 없습니다.");
            }

            // DB에 저장
            counselService.saveChat(question, answer);

            // 클라이언트에게 응답 반환
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Flask 서버와의 통신에 실패했습니다. 에러: " + e.getMessage());
        }
    }
}

