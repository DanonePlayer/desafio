package com.desafio.desafio.infra.ticket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desafio.infra.ticket.models.TicketModel;

public interface JPATicketRepository extends JpaRepository<TicketModel, Long> {
    
}
