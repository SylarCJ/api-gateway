package ust.augury.interview.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class APIGatewayController {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${machine-feed-service.url}")
    private String machineFeedServiceUrl;

    @Value("${machine-config-service.url}")
    private String machineConfigServiceUrl;

    @Value("${repair-service.url}")
    private String repairServiceUrl;

    @Value("${session-service.url}")
    private String sessionServiceUrl;

    @GetMapping("/machine-feeds/{machineId}")
    public ResponseEntity<?> getMachineFeeds(@PathVariable String machineId) {
        String url = machineFeedServiceUrl + machineId;
        return restTemplate.getForEntity(url, Object.class);
    }

    @GetMapping("/machines/{machineId}")
    public ResponseEntity<?> getMachineConfig(@PathVariable String machineId) {
        String url = machineConfigServiceUrl + machineId;
        return restTemplate.getForEntity(url, Object.class);
    }

    @GetMapping("/repairs/{repairId}")
    public ResponseEntity<?> getRepairById(@PathVariable String repairId) {
        String url = repairServiceUrl + repairId;
        return restTemplate.getForEntity(url, Object.class);
    }

    @GetMapping("/repairs/machine/{machineId}")
    public ResponseEntity<?> getRepairDetailsByMachineId(@PathVariable String machineId) {
        String url = repairServiceUrl + "machine" + machineId;
        return restTemplate.getForEntity(url, Object.class);
    }

    @GetMapping("/sessions/{sessionId}")
    public ResponseEntity<?> getSessionById(@PathVariable String sessionId) {
        String url = sessionServiceUrl + sessionId;
        return restTemplate.getForEntity(url, Object.class);
    }

    @GetMapping("/sessions/machine/{machineId}")
    public ResponseEntity<?> getSessionDetailsByMachineId(@PathVariable String machineId) {
        String url = sessionServiceUrl + "machine" + machineId;
        return restTemplate.getForEntity(url, Object.class);
    }
}

