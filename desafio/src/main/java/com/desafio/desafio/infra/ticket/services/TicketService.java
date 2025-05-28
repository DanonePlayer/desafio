package com.desafio.desafio.infra.ticket.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.desafio.application.ticket.useCases.CreateTicketUseCase;
import com.desafio.desafio.application.ticket.useCases.GetAllTicketUseCase;
import com.desafio.desafio.application.ticket.dtos.TicketDTO;
import com.desafio.desafio.infra.ticket.repositories.TicketRepository;

@Service
public class TicketService {
    private GetAllTicketUseCase getAllTicketsUseCase;
    private CreateTicketUseCase createTicketUseCase;

    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
        this.getAllTicketsUseCase = new GetAllTicketUseCase(ticketRepository);
        this.createTicketUseCase = new CreateTicketUseCase(ticketRepository);

    }


    public List<TicketDTO> getAllTickets() {
        return getAllTicketsUseCase.execute();
    }

    public TicketDTO createTicket(TicketDTO ticketDTO) {
        return createTicketUseCase.execute(ticketDTO);
    }
}
