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
    @Column
    private String titulo;

    @ManyToOne
    private ClienteModel codCliente;

    @ManyToOne
    private ModuloModel codModulo;

    @Column
    private Date dataAbertura;
    @Column
    private java.sql.Date dataEncerramento;

    public TicketModel(Ticket ticket) {
        this.id = ticket.getId();
        this.titulo = ticket.getTitulo();
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
