package com.desafio.desafio.infra.cliente.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desafio.infra.cliente.models.ClienteModel;

public interface JPAClienteRepository extends JpaRepository<ClienteModel, Long> {
    List<ClienteModel> findByNome (String nome);
}
