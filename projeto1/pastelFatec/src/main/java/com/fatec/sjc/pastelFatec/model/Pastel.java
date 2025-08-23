package com.fatec.sjc.pastelFatec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pastel {

    private String id;
    private String nome;
    private String descricao;
    private Double preco;
    private String tipo; // Salgado ou Doce
}
