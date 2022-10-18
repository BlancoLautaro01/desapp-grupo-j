package ar.edu.unq.desapp.grupoj.desapp.model.enums;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public enum CryptoEnum {

    ALICEUSDT("ALICEUSDT"),
    MATICUSDT("MATICUSDT"),
    AXSUSDT("AXSUSDT"),
    AAVEUSDT("AAVEUSDT"),
    ATOMUSDT("ATOMUSDT"),
    NEOUSDT("NEOUSDT"),
    DOTUSDT("DOTUSDT"),
    ETHUSDT("ETHUSDT"),
    CAKEUSDT("CAKEUSDT"),
    BTCUSDT("BTCUSDT"),
    BNBUSDT("BNBUSDT"),
    ADAUSDT("ADAUSDT"),
    TRXUSDT("TRXUSDT"),
    AUDIOUSDT("AUDIOUSDT");

    private final String name;

    CryptoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static List<String> stringValues() {
        List<String> stringValues = new ArrayList<>();
        for(CryptoEnum crypto: CryptoEnum.values()) {
            stringValues.add(crypto.getName());
        }

        return stringValues;
    }

    public static String concatenatedStringValues() {
        StringBuilder res = new StringBuilder();
        List<String> stringValues = new ArrayList<>();
        for(CryptoEnum crypto: CryptoEnum.values()) {
            stringValues.add(crypto.getName());
        }

        for(String value: stringValues) {
            res.append(value).append("/");
        }

        return res.substring(0, res.length()-1) + ".";
    }

}
