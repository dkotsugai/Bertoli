package com.fatec.sjc.pastelFatec2.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Categoria {
    SALGADO("Salgado"),
    DOCE("Doce"),
    BEBIDA("Bebida"),;

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static Categoria fromDescricao(String value) {
        for (Categoria c : values()) {
            if (c.descricao.equalsIgnoreCase(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Categoria inválida: " + value);
    }
}
