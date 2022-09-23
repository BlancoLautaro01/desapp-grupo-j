package ar.edu.unq.desapp.grupoj.desapp.factories;


import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;

public class UserFactory {
    public static User anyUserWithName(String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

    public static User anyUserWithSurname(String surname) {
        User user = new User();
        user.setSurname(surname);
        return user;
    }

    public static User anyUserWithPassword(String password) {
        User user = new User();
        user.setPassword(password);
        return user;
    }

    public static User anyUserWithEmail(String email) {
        User user = new User();
        user.setEmail(email);
        return user;
    }

    public static User anyUserWithAddress(String address) {
        User user = new User();
        user.setAddress(address);
        return user;
    }

    public static User anyUserWithCVU(String cvu) {
        User user = new User();
        user.setCvu(cvu);
        return user;
    }

    public static User anyUserWithCryptoWallet(String cryptoWallet) {
        User user = new User();
        user.setCryptoWallet(cryptoWallet);
        return user;
    }

    public static User anyUserWithId(Integer id) {
        User user = new User();
        user.setUserId(id);
        return user;
    }

    public static User createUser(Integer userId, String name, String surname, String password, String email, String address, String cvu, String cryptoWallet, Integer operationAmount, Integer score) {
        User user = new User(userId, name, surname, password, email, address, cvu, cryptoWallet, operationAmount, score);
        return user;
    }

    public static User anyUserWithOperationsAmountAndScore(Integer operationsAmount, Integer score) {
        User user = new User();
        user.setOperationAmount(operationsAmount);
        user.setScore(score);
        return user;
    }
 }
