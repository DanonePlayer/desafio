package com.desafio.desafio.infra.modulo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desafio.infra.modulo.models.ModuloModel;

public interface JPAModuloRepository extends JpaRepository<ModuloModel, Long> {
    List<ModuloModel> findByNome(String nome);

}
