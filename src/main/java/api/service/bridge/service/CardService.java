package api.service.bridge.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardService {
    private final RestTemplate restTemplate;
    private final String cardApiUrl = "http://localhost:8085/api/cards";

    public CardService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public boolean checkCardApiStatus() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(cardApiUrl + "/health", String.class);
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            return false;
        }
    }
}