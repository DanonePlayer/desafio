package com.desafio.desafio.application.ticket.useCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import com.desafio.desafio.application.ticket.dtos.TicketDTO;
import com.desafio.desafio.application.ticket.dtos.TicketDTOListCustom;
import com.desafio.desafio.domain.ticket.ITicketRepository;
import com.desafio.desafio.domain.ticket.entities.Ticket;
import com.desafio.desafio.shared.useCases.IUseCase;

public class GetAllTicketUseCase implements IUseCase<TicketDTOListCustom, List<TicketDTO>> {
    public static final Logger LOGGER = Logger.getLogger(GetAllTicketUseCase.class.getName());
    private ITicketRepository ticketRepository;

    public GetAllTicketUseCase(ITicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TicketDTO> execute(TicketDTOListCustom ticketDTOListCustom) {
        List<Ticket> tickets = new ArrayList<>(ticketRepository.getAll()); 
        
        if (ticketDTOListCustom.isOrderByClient()) {
            tickets.sort(Comparator.comparing(ticket -> ticket.getCodCliente().getNome()));
        } else if (ticketDTOListCustom.isOrderByModule()) {
            tickets.sort(Comparator.comparing(ticket -> ticket.getCodModulo().getNome()));
        } else {
        Collections.shuffle(tickets);   
    }

        return tickets.stream()
                .map(TicketDTO::new)
                .toList();
    }
       
}
