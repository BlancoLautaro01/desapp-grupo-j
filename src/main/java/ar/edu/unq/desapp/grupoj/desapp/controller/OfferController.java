package ar.edu.unq.desapp.grupoj.desapp.controller;

import ar.edu.unq.desapp.grupoj.desapp.exception.cases.InvalidOfferRequestException;
import ar.edu.unq.desapp.grupoj.desapp.exception.cases.UserNotFoundException;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.request.OfferRequest;
import ar.edu.unq.desapp.grupoj.desapp.service.OfferService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/offer")
@Api(value = "", tags={"Offer Controller"})
@Tag(name = "Offer Controller", description = "Offer Methods")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<Offer> findAll() {
        return offerService.findAll();
    }

    @PostMapping
    public Offer createOffer(@RequestBody OfferRequest offerRequest) throws InvalidOfferRequestException, UserNotFoundException {
        return offerService.createOffer(offerRequest);
    }
}
