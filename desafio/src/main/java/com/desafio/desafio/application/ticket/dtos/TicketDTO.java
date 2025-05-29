package com.desafio.desafio.application.ticket.dtos;

import java.util.Date;

import com.desafio.desafio.application.clientes.dtos.ClienteDTO;
import com.desafio.desafio.application.modulo.dtos.ModuloDTO;
import com.desafio.desafio.domain.ticket.entities.Ticket;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String titulo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ClienteDTO codCliente;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ModuloDTO codModulo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(required = false)
    private Date dataAbertura;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(required = false)
    private Date dataEncerramento;

    public TicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.titulo = ticket.getTitulo();

        if (ticket.getCodCliente() != null) {
            this.codCliente = new ClienteDTO(ticket.getCodCliente());
        } else {
            this.codCliente = null;
        }
        if (ticket.getCodModulo() != null) {
            this.codModulo = new ModuloDTO(ticket.getCodModulo());
        } else {
            this.codModulo = null;
        }
        this.dataAbertura = ticket.getDataAbertura();
        this.dataEncerramento = ticket.getDataEncerramento();
    }

    public Ticket toEntity() {
        return new Ticket(
            id == null ? null : id,
            titulo == null ? null : titulo,
            codCliente == null ? null : codCliente.toEntity(),
            codModulo == null ? null : codModulo.toEntity(),
            dataAbertura == null ? null : dataAbertura,
            dataEncerramento == null ? null : dataEncerramento
        );
    }
}
