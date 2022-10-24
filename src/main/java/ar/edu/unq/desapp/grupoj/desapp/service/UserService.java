package ar.edu.unq.desapp.grupoj.desapp.service;

import ar.edu.unq.desapp.grupoj.desapp.exception.cases.InvalidDateFormatException;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.transaction.Transaction;
import ar.edu.unq.desapp.grupoj.desapp.model.enums.CryptoEnum;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.OperatedCryptosDto;
import ar.edu.unq.desapp.grupoj.desapp.repository.TransactionRepository;
import ar.edu.unq.desapp.grupoj.desapp.repository.UserRepository;
import ar.edu.unq.desapp.grupoj.desapp.exception.cases.UserNotFoundException;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.request.LoginRequest;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.LoginDto;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.request.UserRequest;
import ar.edu.unq.desapp.grupoj.desapp.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private JWTUtil jwtUtil;

    public LoginDto login(LoginRequest loginRequest) throws UserNotFoundException {
        User user = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword())
                .orElseThrow(() -> new UserNotFoundException("Invalid Email or Password"));

        return new LoginDto(user.getName(), jwtUtil.getJWTToken(user.getUserId().toString()));
    }

    public User register(UserRequest userRequest) {
        User user = new User(
            null,
            userRequest.getName(),
            userRequest.getSurname(),
            userRequest.getPassword(),
            userRequest.getEmail(),
            userRequest.getAddress(),
            userRequest.getCvu(),
            userRequest.getCryptoWallet(),
                0, 0
        );

        return userRepository.save(user);
    }

    public List<OperatedCryptosDto> getOperatedAmount(
            Integer startDay,
            Integer startMonth,
            Integer startYear,
            Integer endDay,
            Integer endMonth,
            Integer endYear) throws InvalidDateFormatException, UserNotFoundException {

        String startDate = this.generateDate(startDay, startMonth, startYear);
        String endDate = this.generateDate(endDay, endMonth, endYear);

        User user = this.getLoggedUser();

        List<OperatedCryptosDto> result = new ArrayList<>();
        List<Transaction> userTransactions = transactionRepository.findByUserFinishedBetween(user, startDate, endDate);
        for(String crypto: CryptoEnum.stringValues()) {
            Double amount = this.getOperatedAmountByCrypto(crypto, userTransactions);
            result.add(new OperatedCryptosDto(crypto, amount));
        }

        return result;
    }

    private Double getOperatedAmountByCrypto(String crypto, List<Transaction> userTransactions) {
        // First we filter transactions by crypto.
        List<Transaction> transactionsByCrypto = new ArrayList<>();
        for(Transaction transaction: userTransactions) {
            if(transaction.getOffer().getCryptocurrency().equals(crypto)) {
                transactionsByCrypto.add(transaction);
            }
        }

        // Then sum all amounts.
        Double res = 0.0;
        for(Transaction transaction: transactionsByCrypto) {
            res += transaction.getOffer().getCryptocurrencyAmount();
        }

        return res;
    }

    private String generateDate(Integer day, Integer month, Integer year) throws InvalidDateFormatException {
        if(year.toString().length() != 4 || month.toString().length() != 2 || day.toString().length() != 2) {
            throw new InvalidDateFormatException();
        }

        return year + "-" + month + "-" + day;
    }

    public User getLoggedUser() throws UserNotFoundException {
        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return userRepository.findById(Integer.valueOf(userId))
                .orElseThrow(() -> new UserNotFoundException("Invalid UserId"));
    }
}
