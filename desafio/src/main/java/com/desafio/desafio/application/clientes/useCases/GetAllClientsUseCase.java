package com.desafio.desafio.application.clientes.useCases;

import java.util.List;

import com.desafio.desafio.application.clientes.dtos.ClienteDTO;
import com.desafio.desafio.application.shared.useCases.IVoidUseCase;
import com.desafio.desafio.domain.cliente.IClienteRepository;
import com.desafio.desafio.domain.cliente.entities.Cliente;

public class GetAllClientsUseCase implements IVoidUseCase<List<ClienteDTO>> {
    private IClienteRepository clienteRepository;

    public GetAllClientsUseCase(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteDTO> execute() {
        List<Cliente> clientes = clienteRepository.getAll();
        
        return clientes.stream()
                .map(cliente -> new ClienteDTO(cliente.getId(), cliente.getNome()))
                .toList();
    }

    
}
