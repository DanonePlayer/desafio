package com.desafio.desafio.application.modulo.dtos;

import com.desafio.desafio.domain.modulo.entities.Modulo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModuloDTO {
    private Long id;
    private String nome;

    public ModuloDTO(Modulo modulo) {
        this.id = modulo.getId();
        this.nome = modulo.getNome();
    }
}
