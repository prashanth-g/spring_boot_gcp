package com.prashanth.spring.gcloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class GCPRestController {

    @GetMapping("/greet/{name}")
    String greet (@PathVariable String name) {
        return "Halo "+ name;
    }


    @GetMapping("/client")
    Collection<String> client() {
        return Stream.of("DJB", "SG", "VS").collect(Collectors.toList());
    }
}
