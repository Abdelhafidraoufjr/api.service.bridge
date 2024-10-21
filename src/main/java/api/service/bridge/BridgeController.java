package api.service.bridge;

import api.service.bridge.service.AccountService;
import api.service.bridge.service.AuthService;
import api.service.bridge.service.CardService;
import api.service.bridge.service.TransferService;
import com.sun.jdi.connect.spi.TransportService;
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

    @Autowired
    private CardService cardService;

    @Autowired
    private TransferService transferService;

    @GetMapping("/health")
    public ResponseEntity<Map<String, Boolean>> checkAPIsHealth() {
        Map<String, Boolean> statusMap = new HashMap<>();
        statusMap.put("api.service.authentication", authService.checkAuthApiStatus());
        statusMap.put("api.service.account", accountService.checkAccountApiStatus());
        statusMap.put("api.service.card", cardService.checkCardApiStatus());
        statusMap.put("api.service.transfer", transferService.checkTransferApiStatus());
        return ResponseEntity.ok(statusMap);
    }
}
