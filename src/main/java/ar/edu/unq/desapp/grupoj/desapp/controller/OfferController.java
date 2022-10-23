package ar.edu.unq.desapp.grupoj.desapp.controller;

import ar.edu.unq.desapp.grupoj.desapp.exception.cases.InvalidOfferRequestException;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.request.OfferRequest;
import ar.edu.unq.desapp.grupoj.desapp.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<Offer> findAll() {
        return offerService.findAll();
    }

    @PostMapping
    public Offer createOffer(@Valid @RequestBody OfferRequest offerRequest) throws InvalidOfferRequestException {
        return offerService.createOffer(offerRequest);
    }
}
