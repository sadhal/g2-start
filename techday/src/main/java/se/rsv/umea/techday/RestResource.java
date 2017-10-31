package se.rsv.umea.techday;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestResource {

    private final Logger LOGGER = LoggerFactory.getLogger(RestResource.class);

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(path = "/greeting", produces = "application/json")
    public ResponseEntity<?> greeting() {
        LOGGER.info("endpoint /greeting called");

        Map<String, String> resp = new HashMap<>();
        resp.put("greeting-response", "Hello, world!");
        return ResponseEntity.ok(resp);
    }

    @RequestMapping(path = "/person", method = RequestMethod.GET, produces = "application/json")
    public List<Person> getEmAll() {
        LOGGER.info("endpoint /person method GET");

        return personRepository.findAll();
    }

    @RequestMapping(path = "/person", method = RequestMethod.POST, consumes = "application/json")
    public String createPerson(@RequestBody Person person) {
        LOGGER.info("endpoint /person method POST, person in {}", person);

        person = personRepository.save(person);

        LOGGER.info("endpoint /person method POST, id out {}", person.id);
        return person.id;
    }
}
