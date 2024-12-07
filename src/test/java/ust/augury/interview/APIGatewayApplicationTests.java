package ust.augury.interview;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class APIGatewayApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testGetMachineFeeds() {
        ResponseEntity<Object> response = testRestTemplate.getForEntity(
                "/api/machine-feeds/5f54dd217546020001758b7b",
                Object.class
        );
        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
    }

    @Test
    void testGetMachineConfig() {
        ResponseEntity<Object> response = testRestTemplate.getForEntity(
                "/api/machines/5f54dd217546020001758b7b",
                Object.class
        );
        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
    }
}
