package com.desafio.desafio.application.ticket.useCases;

import java.time.LocalDate;
import java.util.Date;

import com.desafio.desafio.application.ticket.dtos.TicketDTO;
import com.desafio.desafio.domain.cliente.entities.Cliente;
import com.desafio.desafio.domain.modulo.entities.Modulo;
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
                new Cliente(ticketDTO.getCodCliente().getId()),
                new Modulo(ticketDTO.getCodModulo().getId()),
                new Date(),
                null
            )
        );

        Ticket saved = ticketRepository.create(ticket);

        return new TicketDTO(saved);

    }

}
