package com.mission.authservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DashboardController {

    // 외부 API 호출을 위한 도구
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/dashboard")
    public Map<String, Object> getDashboard() {
        Map<String, Object> result = new HashMap<>();

        // 1. [Java] 메인 로직: 유저 정보 제공
        result.put("user_role", "Java Backend Developer");
        result.put("service_status", "Online");

        // 2. [Kotlin] 서비스 호출 (8081 포트)
        try {
            // URL: localhost의 코틀린 서비스 주소
            String contentUrl = "http://localhost:8081/posts";
            // 코틀린에서 받은 데이터를 Object.class 형태로 받습니다.
            Object posts = restTemplate.getForObject(contentUrl, Object.class);
            result.put("recent_posts", posts);
        } catch (Exception e) {
            result.put("recent_posts", "Error: Cannot reach Kotlin service on 8081");
        }

        // 3. [Python] 서비스 호출 (8082 포트)
        try {
            // URL: localhost의 파이썬 서비스 주소
            String aiUrl = "http://localhost:8082/recommendations";
            // 파이썬에서 받은 데이터를 Object.class 형태로 받습니다.
            Object recommendations = restTemplate.getForObject(aiUrl, Object.class);
            result.put("ai_recommendations", recommendations);
        } catch (Exception e) {
            result.put("ai_recommendations", "Error: Cannot reach Python service on 8082");
        }

        return result;
    }
}
