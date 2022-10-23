package ar.edu.unq.desapp.grupoj.desapp.service;

import ar.edu.unq.desapp.grupoj.desapp.exception.cases.InvalidTransactionRequestException;
import ar.edu.unq.desapp.grupoj.desapp.exception.cases.OfferNotFoundException;
import ar.edu.unq.desapp.grupoj.desapp.exception.cases.TransactionNotFoundException;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.transaction.Transaction;
import ar.edu.unq.desapp.grupoj.desapp.model.enums.TransactionStateEnum;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.TransactionDto;
import ar.edu.unq.desapp.grupoj.desapp.repository.OfferRepository;
import ar.edu.unq.desapp.grupoj.desapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TransactionService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDto startTransaction(Integer offerId) throws Exception {
        // TODO: Tenemos que ver como sacar el user loggeado desde el token de autorizacion.
        User loggedUser = new User();

        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new OfferNotFoundException("Invalid OfferId"));

        Transaction transaction = this.saveTransaction(offer, loggedUser);

        return new TransactionDto(
                transaction.getTransactionId(),
                transaction.getCreationDate(),
                offer,
                loggedUser,
                transaction.getState().getAction(),
                transaction.getState().getDepositAddress()
        );
    }

    private Transaction saveTransaction(Offer offer, User loggedUser) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());

        Transaction transaction = new Transaction();
        transaction.setOffer(offer);
        transaction.setUser(loggedUser);
        transaction.setStateId(1);
        transaction.setCreationDate(formatter.format(date));

        transaction = transactionRepository.save(transaction);
        return transaction;
    }

    public TransactionDto changeTransactionState(Integer transactionId, String state) throws Exception {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("Invalid TransactionId"));

        if(!TransactionStateEnum.stringValues().contains(state)) {
            throw new InvalidTransactionRequestException(
                    "Invalid state. Available values are: INITIATED/PAYMENT_DONE/FINISHED/CANCELED");
        }
        if(TransactionStateEnum.valueOf(state) == TransactionStateEnum.FINISHED) {
            // TODO: Validar que el precio no haya fluctuado.
        }

        Integer stateId = TransactionStateEnum.valueOf(state).getTransactionStateID();
        transaction.setStateId(stateId);

        transactionRepository.save(transaction);
        return new TransactionDto(
                transaction.getTransactionId(),
                transaction.getCreationDate(),
                transaction.getOffer(),
                transaction.getUser(),
                transaction.getState().getAction(),
                transaction.getState().getDepositAddress());
    }
}
