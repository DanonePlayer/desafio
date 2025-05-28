package com.desafio.desafio.application.ticket.dtos;

import java.util.Date;

import com.desafio.desafio.application.clientes.dtos.ClienteDTO;
import com.desafio.desafio.application.modulo.dtos.ModuloDTO;
import com.desafio.desafio.domain.ticket.entities.Ticket;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    private Long id;
    private String titulo;
    private ClienteDTO codCliente;
    private ModuloDTO codModulo;
    @JsonProperty(required = false)
    private Date dataAbertura;
    @JsonProperty(required = false)
    private Date dataEncerramento;

    public TicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.titulo = ticket.getTitulo();
        this.codCliente = new ClienteDTO(ticket.getCodCliente());
        this.codModulo = new ModuloDTO(ticket.getCodModulo());
        this.dataAbertura = ticket.getDataAbertura();
        this.dataEncerramento = ticket.getDataEncerramento();
    }
}
