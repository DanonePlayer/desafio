package com.desafio.desafio.domain.ticket;

import java.util.List;

import com.desafio.desafio.domain.ticket.entities.Ticket;

public interface ITicketRepository {
    Ticket getById(Long id);
    Ticket create(Ticket ticket);
    Ticket update(Ticket ticket);
    void deleteById(Long id);
    List<Ticket> getAll();
    List<Ticket> getByClienteId(Long clienteId);
    List<Ticket> getByModuloId(Long moduloId);
    List<Ticket> getByTitulo(String titulo);
}
