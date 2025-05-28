package com.desafio.desafio.infra.ticket.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.desafio.desafio.domain.ticket.ITicketRepository;
import com.desafio.desafio.domain.ticket.entities.Ticket;
import com.desafio.desafio.infra.ticket.models.TicketModel;

@Repository
public class TicketRepository implements ITicketRepository {

    @Autowired
    private JPATicketRepository jpaTicketRepository;

    @Override
    public Ticket getById(Long id) {
        return this.jpaTicketRepository.findById(id)
                                       .map(TicketModel::toEntity)
                                       .orElse(null);
    }

    @Override
    public Ticket create(Ticket ticket) {
        TicketModel model = new TicketModel(ticket);
        return this.jpaTicketRepository.save(model).toEntity();
    }

    @Override
    public Ticket update(Ticket ticket) {
        TicketModel model = new TicketModel(ticket);
        return this.jpaTicketRepository.save(model).toEntity();
    }

    @Override
    public void deleteById(Long id) {
        this.jpaTicketRepository.deleteById(id);
    }

    @Override
    public List<Ticket> getAll() {
        List<TicketModel> ticketModels = this.jpaTicketRepository.findAll();
        return ticketModels.stream()
                           .map(TicketModel::toEntity)
                           .toList();
    }

    @Override
    public List<Ticket> getByClienteId(Long clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByClienteId'");
    }

    @Override
    public List<Ticket> getByModuloId(Long moduloId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByModuloId'");
    }

    @Override
    public List<Ticket> getByTitulo(String titulo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByTitulo'");
    }
    
}
