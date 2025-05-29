package com.desafio.desafio.infra.ticket.models;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import com.desafio.desafio.domain.ticket.entities.Ticket;
import com.desafio.desafio.infra.cliente.models.ClienteModel;
import com.desafio.desafio.infra.modulo.models.ModuloModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
public class TicketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "fk_id_client")
    private ClienteModel codCliente;

    @ManyToOne
    @JoinColumn(name = "fk_id_module")
    private ModuloModel codModulo;

    @Column(name = "opening_date")
    private Date dataAbertura;
    @Column(name = "closing_date")
    private java.sql.Date dataEncerramento;

    public TicketModel(Ticket ticket) {
        this.id = ticket.getId();
        this.titulo = ticket.getTitulo();

        if (ticket.getCodCliente() != null) {
            this.codCliente = new ClienteModel(ticket.getCodCliente());
        } else {
            this.codCliente = null;
        }

        if (ticket.getCodModulo() != null) {
            this.codModulo = new ModuloModel(ticket.getCodModulo());
        } else {
            this.codModulo = null;
        }

        this.dataAbertura = ticket.getDataAbertura();
        this.dataEncerramento = ticket.getDataEncerramento() != null ? new java.sql.Date(ticket.getDataEncerramento().getTime()) : null;
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
