package com.desafio.desafio.infra.cliente.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.desafio.desafio.domain.cliente.IClienteRepository;
import com.desafio.desafio.domain.cliente.entities.Cliente;
import com.desafio.desafio.infra.cliente.models.ClienteModel;

@Repository
public class ClienteRepository implements IClienteRepository{
    @Autowired
    private JPAClienteRepository jpaClienteRepository;

    @Override
    public List<Cliente> getByName(String nome) {
        List<ClienteModel> clienteModels = this.jpaClienteRepository.findByNome(nome);
        return clienteModels.stream()
                            .map(ClienteModel::toEntity)
                            .toList();
    }

    @Override
    public Cliente getById(Long id) {
        return this.jpaClienteRepository.findById(id)
                                   .map(ClienteModel::toEntity)
                                   .orElse(null);
    }

    @Override
    public Cliente create(Cliente cliente) {
        ClienteModel model = new ClienteModel(cliente);
        return this.jpaClienteRepository.save(model).toEntity();
    }

    @Override
    public Cliente update(Cliente cliente) {
        ClienteModel model = new ClienteModel(cliente);
        return this.jpaClienteRepository.save(model).toEntity();
    }

    @Override
    public void delete(Long id) {
        this.jpaClienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> getAll() {
        List<ClienteModel> clienteModels = this.jpaClienteRepository.findAll();
        return clienteModels.stream()
                            .map(ClienteModel::toEntity)
                            .toList();
    }

}
