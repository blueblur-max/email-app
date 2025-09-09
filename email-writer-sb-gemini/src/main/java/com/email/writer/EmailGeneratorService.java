package com.email.writer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class EmailGeneratorService {

    private final String apiKey;
    private final String apiUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    public EmailGeneratorService(
            @Value("${gemini.api.key}") String apiKey,
            @Value("${gemini.api.url}") String apiUrl
    ) {
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }

    public String generateEmail(String content, String tone) {
        String prompt = "Write an email in a " + tone + " tone. Content: " + content;

        Map<String, Object> textPart = Map.of("text", prompt);
        Map<String, Object> parts = Map.of("parts", List.of(textPart));
        Map<String, Object> requestBody = Map.of("contents", List.of(parts));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-goog-api-key", apiKey);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                apiUrl, HttpMethod.POST, requestEntity, Map.class
        );

        try {
            List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.getBody().get("candidates");
            if (candidates != null && !candidates.isEmpty()) {
                Map<String, Object> first = candidates.get(0);
                Map<String, Object> contentMap = (Map<String, Object>) first.get("content");
                List<Map<String, Object>> partsList = (List<Map<String, Object>>) contentMap.get("parts");
                return (String) partsList.get(0).get("text");
            }
        } catch (Exception e) {
            return "Error parsing Gemini response: " + e.getMessage();
        }
        return "No response from Gemini.";
    }
}
