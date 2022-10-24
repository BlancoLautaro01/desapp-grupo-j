package ar.edu.unq.desapp.grupoj.desapp.controller;

import ar.edu.unq.desapp.grupoj.desapp.exception.cases.InvalidDateFormatException;
import ar.edu.unq.desapp.grupoj.desapp.exception.cases.UserNotFoundException;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.OperatedCryptosDto;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.request.LoginRequest;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.LoginDto;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.request.UserRequest;
import ar.edu.unq.desapp.grupoj.desapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "", tags={"User Controller"})
@Tag(name = "User Controller", description = "User Methods")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public LoginDto login(@Valid @RequestBody LoginRequest loginRequest) throws UserNotFoundException {
        return userService.login(loginRequest);
    }

    @PostMapping
    public User register(@Valid @RequestBody UserRequest userRequest) {
        return userService.register(userRequest);
    }

    @GetMapping("/getOperatedAmounts")
    public List<OperatedCryptosDto> getOperatedAmount(
            @RequestParam Integer startDay,
            @RequestParam Integer startMonth,
            @RequestParam Integer startYear,
            @RequestParam Integer endDay,
            @RequestParam Integer endMonth,
            @RequestParam Integer endYear
    ) throws InvalidDateFormatException, UserNotFoundException {
        // Informar al usuario el volumen operado de cripto activos entre dos fechas
        return userService.getOperatedAmount(startDay, startMonth, startYear, endDay, endMonth, endYear);
    }
}