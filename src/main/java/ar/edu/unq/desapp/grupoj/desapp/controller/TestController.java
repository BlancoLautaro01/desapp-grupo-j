package ar.edu.unq.desapp.grupoj.desapp.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(value = "", tags={"Test Controller"})
@Tag(name = "Test Controller", description = "Test Methods")
public class TestController {

    @GetMapping
    public String test() {
        return "Hello World!";
    }
}

