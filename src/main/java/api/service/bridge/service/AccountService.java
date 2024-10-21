package api.service.bridge.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class AccountService {
    private final RestTemplate restTemplate;
    private final String accountApiUrl = "http://localhost:8083/api/accounts";

    public AccountService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean checkAccountApiStatus() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(accountApiUrl + "/health", String.class);
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            return false;
        }
    }
}
