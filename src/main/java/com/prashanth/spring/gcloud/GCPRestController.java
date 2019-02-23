package com.prashanth.spring.gcloud;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@Log4j2
public class GCPRestController {

    private final RestTemplate restTemplate;

    GCPRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/greet/{name}")
    String greet (@PathVariable String name) {
        log.info("Received : "+name);
        return "Halo "+ name;
    }

    @GetMapping("/client")
    Collection<String> client() {
        return Stream.of("DJB", "SG", "VS")
                .map(this::call)
                .collect(Collectors.toList());
    }

    private final String call(String name) {
        return this.restTemplate
                .getForEntity("http://localhost:8080/greet/{name}", String.class, name)
                .getBody();
    }
}
