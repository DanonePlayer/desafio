package com.desafio.desafio.application.ticket.useCases;

import java.util.List;

import com.desafio.desafio.application.clientes.dtos.ClienteDTO;
import com.desafio.desafio.application.modulo.dtos.ModuloDTO;
import com.desafio.desafio.application.ticket.dtos.TicketDTO;
import com.desafio.desafio.domain.ticket.ITicketRepository;
import com.desafio.desafio.domain.ticket.entities.Ticket;
import com.desafio.desafio.shared.useCases.IVoidUseCase;

public class GetAllTicketUseCase implements IVoidUseCase<List<TicketDTO>> {
    private ITicketRepository ticketRepository;

    public GetAllTicketUseCase(ITicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TicketDTO> execute() {
        List<Ticket> tickets = ticketRepository.getAll();

        return tickets.stream()
                .map(ticket -> new TicketDTO(ticket.getId(), ticket.getTitulo(), new ClienteDTO(ticket.getCodCliente()), new ModuloDTO(ticket.getCodModulo()), ticket.getDataAbertura(), ticket.getDataEncerramento()))
                .toList();
    }
       
}
