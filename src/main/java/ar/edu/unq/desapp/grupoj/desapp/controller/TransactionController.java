package ar.edu.unq.desapp.grupoj.desapp.controller;

import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.TransactionDto;
import ar.edu.unq.desapp.grupoj.desapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/start/{offerId}")
    public TransactionDto processTransaction(@PathVariable Integer offerId) throws Exception {
        return transactionService.startTransaction(offerId);
    }

    @PutMapping("/changeState/{transactionId}")
    public TransactionDto changeTransactionState(
            @RequestParam String state,
            @PathVariable Integer transactionId) throws Exception {
        return transactionService.changeTransactionState(transactionId, state);
    }
}
