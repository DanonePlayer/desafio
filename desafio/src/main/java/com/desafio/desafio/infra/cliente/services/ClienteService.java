package com.desafio.desafio.infra.cliente.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.desafio.application.clientes.dtos.ClienteDTO;
import com.desafio.desafio.application.clientes.useCases.GetAllClientsUseCase;
import com.desafio.desafio.infra.cliente.repositories.ClienteRepository;

import ch.qos.logback.core.net.server.Client;

@Service
public class ClienteService {
    private GetAllClientsUseCase getAllClientsUseCase;

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        this.getAllClientsUseCase = new GetAllClientsUseCase(clienteRepository);
    }

    public List<ClienteDTO> getAllClients() {
        return getAllClientsUseCase.execute();
    }
}