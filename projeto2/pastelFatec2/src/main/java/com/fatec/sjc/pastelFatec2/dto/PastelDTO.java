package com.fatec.sjc.pastelFatec2.dto;

import com.fatec.sjc.pastelFatec2.model.Categoria;
import com.fatec.sjc.pastelFatec2.model.Pastel;

public record PastelDTO(
    Long id,
    String nome,
    String descricao,
    Double preco,
    Categoria categoria
) {}

