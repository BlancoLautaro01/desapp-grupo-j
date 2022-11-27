package ar.edu.unq.desapp.grupoj.desapp.repository;

import ar.edu.unq.desapp.grupoj.desapp.model.entities.Crypto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CryptoRepository extends CrudRepository<Crypto, Integer> {

    @Query( "SELECT c FROM Crypto c WHERE c.symbol = ?1")
    List<Crypto> findAllCryptoFor(String symbol);

    @Modifying
    @Query( "DELETE FROM Crypto c WHERE c.updateTime < ?1")
    void deleteCryptoPast24hr(LocalDateTime date);
}
