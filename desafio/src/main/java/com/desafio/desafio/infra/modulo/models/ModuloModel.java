package com.desafio.desafio.infra.modulo.models;

import com.desafio.desafio.domain.modulo.entities.Modulo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "modulo")
public class ModuloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String nome;

    public ModuloModel(Modulo nome) {
        this.id = nome.getId();
        this.nome = nome.getNome();
    }

    public Modulo toEntity() {
        return new Modulo(
            id == null ? null : id,
            nome == null ? null : nome
        );
    }
}
