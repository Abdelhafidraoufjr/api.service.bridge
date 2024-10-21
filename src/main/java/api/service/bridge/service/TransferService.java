package api.service.bridge.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransferService {
    private final RestTemplate restTemplate;
    private final String transferApiUrl = "http://localhost:8084/api/transfers";

    public TransferService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public boolean checkTransferApiStatus() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(transferApiUrl + "/health", String.class);
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            return false;
        }
    }
}