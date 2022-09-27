package ar.edu.unq.desapp.grupoj.desapp.controller;

import ar.edu.unq.desapp.grupoj.desapp.model.inout.LoginDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asd")
public class TestController {

    @GetMapping
    public LoginDto login() {
        return new LoginDto("asd", "asd");
    }
}
