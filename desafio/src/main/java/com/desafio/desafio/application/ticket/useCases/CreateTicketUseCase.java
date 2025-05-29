package com.desafio.desafio.application.ticket.useCases;

import java.util.Date;

import com.desafio.desafio.application.ticket.dtos.TicketDTO;
import com.desafio.desafio.domain.cliente.IClienteRepository;
import com.desafio.desafio.domain.modulo.IModuloRepository;
import com.desafio.desafio.domain.ticket.ITicketRepository;
import com.desafio.desafio.domain.ticket.entities.Ticket;
import com.desafio.desafio.shared.useCases.IUseCase;

public class CreateTicketUseCase implements IUseCase<TicketDTO, TicketDTO> {
    private ITicketRepository ticketRepository;
    private IClienteRepository clienteRepository;
    private IModuloRepository moduloRepository;


    public CreateTicketUseCase(ITicketRepository ticketRepository, IClienteRepository clienteRepository, IModuloRepository moduloRepository) {
        this.ticketRepository = ticketRepository;
        this.clienteRepository = clienteRepository;
        this.moduloRepository = moduloRepository;
    }

    @Override
    public TicketDTO execute(TicketDTO ticketDTO) {
        var cliente = clienteRepository.getById(ticketDTO.getCodCliente().getId());
        var modulo = moduloRepository.getById(ticketDTO.getCodModulo().getId());
        Ticket ticket = ticketRepository.create(
            new Ticket(
                null,
                ticketDTO.getTitulo(),
                cliente,
                modulo,
                new Date(),
                null
            )
        );

        Ticket teste = ticket;
        return new TicketDTO(teste);

    }

}
