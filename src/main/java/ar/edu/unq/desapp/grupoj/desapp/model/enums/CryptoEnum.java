package ar.edu.unq.desapp.grupoj.desapp.model.enums;

import lombok.Data;

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

}
