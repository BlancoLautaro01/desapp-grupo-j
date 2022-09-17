package ar.edu.unq.desapp.grupoj.desapp.service;

import ar.edu.unq.desapp.grupoj.desapp.UserRepository;
import ar.edu.unq.desapp.grupoj.desapp.exception.cases.UserNotFoundException;
import ar.edu.unq.desapp.grupoj.desapp.model.User;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.LoginRequest;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.LoginResponse;
import ar.edu.unq.desapp.grupoj.desapp.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtil jwtUtil;

    public LoginResponse login(LoginRequest loginRequest) throws UserNotFoundException {
        User user = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword())
                .orElseThrow(() -> new UserNotFoundException("Invalid Email or Password"));

        return new LoginResponse(user.getName(), jwtUtil.getJWTToken(user.getName()));
    }

    public User register(User userRequest) {
        return userRepository.save(userRequest);
    }
}
