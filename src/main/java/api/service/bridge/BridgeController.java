package api.service.bridge;

import api.service.bridge.service.AccountService;
import api.service.bridge.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/bridge")
public class BridgeController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/health")
    public ResponseEntity<Map<String, Boolean>> checkAPIsHealth() {
        Map<String, Boolean> statusMap = new HashMap<>();
        statusMap.put("api.service.authentication", authService.checkAuthApiStatus());
        statusMap.put("api.service.account", accountService.checkAccountApiStatus());
        return ResponseEntity.ok(statusMap);
    }
}
