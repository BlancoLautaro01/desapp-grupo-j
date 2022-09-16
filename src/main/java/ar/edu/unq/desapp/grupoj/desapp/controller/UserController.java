package ar.edu.unq.desapp.grupoj.desapp.controller;

import ar.edu.unq.desapp.grupoj.desapp.exception.cases.UserNotFoundException;
import ar.edu.unq.desapp.grupoj.desapp.model.User;
import ar.edu.unq.desapp.grupoj.desapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Api(value = "", tags={"User Controller"})
@Tag(name = "User Controller", description = "User Methods")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) throws UserNotFoundException {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User register(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
}