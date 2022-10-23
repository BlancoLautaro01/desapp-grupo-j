package ar.edu.unq.desapp.grupoj.desapp.repository;

import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Integer>  {

    List<Offer> findAllByStateId(Integer stateId);
}
