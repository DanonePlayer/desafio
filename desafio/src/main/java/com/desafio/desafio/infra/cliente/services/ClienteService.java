package com.desafio.desafio.infra.cliente.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.desafio.application.clientes.dtos.ClienteDTO;
import com.desafio.desafio.application.clientes.useCases.GetAllClientesUseCase;
import com.desafio.desafio.infra.cliente.repositories.ClienteRepository;

@Service
public class ClienteService {
    private GetAllClientesUseCase getAllClientsUseCase;

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        this.getAllClientsUseCase = new GetAllClientesUseCase(clienteRepository);
    }

    public List<ClienteDTO> getAllClients() {
        return getAllClientsUseCase.execute();
    }
}