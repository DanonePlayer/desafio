package com.desafio.desafio.application.ticket.useCases;

import java.util.Date;

import com.desafio.desafio.application.ticket.dtos.TicketDTO;
import com.desafio.desafio.domain.ticket.ITicketRepository;
import com.desafio.desafio.domain.ticket.entities.Ticket;
import com.desafio.desafio.shared.useCases.IUseCase;

public class CreateTicketUseCase implements IUseCase<TicketDTO, TicketDTO> {
    private ITicketRepository ticketRepository;

    public CreateTicketUseCase(ITicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public TicketDTO execute(TicketDTO ticketDTO) {
        Ticket ticket = ticketRepository.create(
            new Ticket(
                null,
                ticketDTO.getTitulo(),
                ticketDTO.getCodCliente().toEntity(),
                ticketDTO.getCodModulo().toEntity(),
                new Date(),
                null
            )
        );

        Ticket saved = ticketRepository.create(ticket);

        return new TicketDTO(saved);

    }

}
