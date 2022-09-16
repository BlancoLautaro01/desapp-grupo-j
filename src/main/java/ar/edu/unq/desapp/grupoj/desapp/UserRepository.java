package ar.edu.unq.desapp.grupoj.desapp;

import ar.edu.unq.desapp.grupoj.desapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
