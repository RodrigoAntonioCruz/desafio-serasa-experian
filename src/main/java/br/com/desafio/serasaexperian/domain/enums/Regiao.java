package br.com.desafio.serasaexperian.domain.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Regiao {

    NORTE("norte"),

    NORDESTE("nordeste"),

    SUL("sul"),

    SUDESTE("sudeste"),

    CENTRO_OESTE("centro oeste"),
    NONE("none");

    private final String region;

    Regiao(String region) {
        this.region = region;
    }

    public static Regiao getName(String region) {
        return Arrays.stream(Regiao.values()).filter(p -> p.getRegion().equalsIgnoreCase(region)).findFirst().orElse(NONE);
    }
}
