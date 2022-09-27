package ar.edu.unq.desapp.grupoj.desapp.service;

import ar.edu.unq.desapp.grupoj.desapp.UserRepository;
import ar.edu.unq.desapp.grupoj.desapp.exception.cases.UserNotFoundException;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.LoginRequest;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.LoginDto;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.UserRequest;
import ar.edu.unq.desapp.grupoj.desapp.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtil jwtUtil;

    public LoginDto login(LoginRequest loginRequest) throws UserNotFoundException {
        User user = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword())
                .orElseThrow(() -> new UserNotFoundException("Invalid Email or Password"));

        return new LoginDto(user.getName(), jwtUtil.getJWTToken(user.getName()));
    }

    public User register(UserRequest userRequest) {
        User user = new User(
            null,
            userRequest.getName(),
            userRequest.getSurname(),
            userRequest.getPassword(),
            userRequest.getEmail(),
            userRequest.getAddress(),
            userRequest.getCvu(),
            userRequest.getCryptoWallet(),
                0, 0
        );

        return userRepository.save(user);
    }
}
