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

    @PostMapping("/start")
    public TransactionDto processTransaction(@RequestParam Integer offerId) throws Exception {
        // Procesar la transacción informada por un usuario. Primer endpoint Crear Transaccion.
        return transactionService.startTransaction(offerId);
    }

    @PutMapping("/changeState/{transactionId}")
    public TransactionDto changeTransactionState(
            @RequestParam String state,
            @PathVariable Integer transactionId) throws Exception {
        // Procesar la transacción informada por un usuario. Segundo endpoint Actualizar Estado.
        return transactionService.changeTransactionState(transactionId, state);
    }
}
