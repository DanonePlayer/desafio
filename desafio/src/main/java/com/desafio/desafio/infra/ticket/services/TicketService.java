package com.desafio.desafio.infra.ticket.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.desafio.application.ticket.useCases.CreateTicketUseCase;
import com.desafio.desafio.application.ticket.useCases.GetAllTicketUseCase;
import com.desafio.desafio.application.ticket.dtos.TicketDTO;
import com.desafio.desafio.application.ticket.dtos.TicketDTOListCustom;
import com.desafio.desafio.infra.cliente.repositories.ClienteRepository;
import com.desafio.desafio.infra.modulo.repositories.ModuloRepository;
import com.desafio.desafio.infra.ticket.repositories.TicketRepository;

@Service
public class TicketService {
    private GetAllTicketUseCase getAllTicketsUseCase;
    private CreateTicketUseCase createTicketUseCase;

    private TicketRepository ticketRepository;
    private ClienteRepository clienteRepository;
    private ModuloRepository moduloRepository;

    public TicketService(TicketRepository ticketRepository, ClienteRepository clienteRepository, ModuloRepository moduloRepository) {
        this.ticketRepository = ticketRepository;
        this.clienteRepository = clienteRepository;
        this.moduloRepository = moduloRepository;
        this.getAllTicketsUseCase = new GetAllTicketUseCase(ticketRepository);
        this.createTicketUseCase = new CreateTicketUseCase(ticketRepository, clienteRepository, moduloRepository);

    }


    public List<TicketDTO> getAllTickets(TicketDTOListCustom ticketDTOListCustom) {
        return getAllTicketsUseCase.execute(ticketDTOListCustom);
    }

    public TicketDTO createTicket(TicketDTO ticketDTO) {
        return createTicketUseCase.execute(ticketDTO);
    }
}
