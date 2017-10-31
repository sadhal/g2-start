package se.rsv.umea.techday;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestResource {

    private final Logger LOGGER = LoggerFactory.getLogger(RestResource.class);

    @RequestMapping(path = "/greeting", produces = "application/json")
    public ResponseEntity<?> greeting() {
        LOGGER.info("endpoint /greeting called");

        Map<String, String> resp = new HashMap<>();
        resp.put("greeting-response", "Hello, world!");
        return ResponseEntity.ok(resp);
    }
}
