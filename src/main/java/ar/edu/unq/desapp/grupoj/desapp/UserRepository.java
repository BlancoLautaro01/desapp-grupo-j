package ar.edu.unq.desapp.grupoj.desapp;

import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);
}
