package com.desafio.desafio.application.receita.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForkifyResponseDTO {
    private int count;
    private List<ReceitaDTO> recipes;
}
