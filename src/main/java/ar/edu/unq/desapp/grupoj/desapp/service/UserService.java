package ar.edu.unq.desapp.grupoj.desapp.service;

import ar.edu.unq.desapp.grupoj.desapp.UserRepository;
import ar.edu.unq.desapp.grupoj.desapp.exception.cases.UserNotFoundException;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Integer userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Invalid UserId"));
    }

    public User createUser(User userRequest) {
        return userRepository.save(userRequest);
    }
}
