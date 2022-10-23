package ar.edu.unq.desapp.grupoj.desapp.repository;

import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.transaction.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>  {

    @Query(value = "SELECT t FROM Transaction t " +
            " WHERE (t.user = :user OR t.offer.user = :user) AND " +
            " (t.creationDate > :dateStart AND t.creationDate < :dateEnd)")
    List<Transaction> findByUserFinishedBetween(User user, String dateStart, String dateEnd);
}
