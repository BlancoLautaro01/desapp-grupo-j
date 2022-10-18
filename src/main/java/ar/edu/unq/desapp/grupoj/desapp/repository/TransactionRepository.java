package ar.edu.unq.desapp.grupoj.desapp.repository;

import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.transaction.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>  {

    @Query(value = "SELECT * FROM transacion " +
            " WHERE user = :user AND " +
            " creation_date > :dateStart AND creation_date < :dateEnd", nativeQuery = true)
    List<Transaction> findByUserFinishedBetween(User user, String dateStart, String dateEnd);
}
