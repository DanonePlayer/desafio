package com.desafio.desafio.domain.cliente;

import java.util.List;

import com.desafio.desafio.domain.cliente.entities.Cliente;

public interface IClienteRepository {
    List<Cliente> getByName(String nome);
    Cliente getById(Long id);
    Cliente create (Cliente cliente);
    Cliente update (Cliente cliente);
    void deleteById (Long id);
    List<Cliente> getAll();

}
