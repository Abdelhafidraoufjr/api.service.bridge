package api.service.bridge.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class AuthService {
    private final RestTemplate restTemplate;
    private final String authApiUrl = "http://localhost:8081/api/auth"; 

    public AuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public boolean checkAuthApiStatus() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(authApiUrl + "/health", String.class);
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            return false;
        }
    }
}
