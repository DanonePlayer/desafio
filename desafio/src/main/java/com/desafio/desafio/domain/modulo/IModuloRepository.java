package com.desafio.desafio.domain.modulo;

import java.util.List;

import com.desafio.desafio.domain.modulo.entities.Modulo;

public interface IModuloRepository {
    List<Modulo> getByName(String nome);
    Modulo getById(Long id);
    Modulo create(Modulo modulo);
    Modulo update(Modulo modulo);
    void deleteById(Long id);
    List<Modulo> getAll();
}
