package com.desafio.desafio.domain.ticket.entities;

import java.util.Date;

import com.desafio.desafio.domain.cliente.entities.Cliente;
import com.desafio.desafio.domain.modulo.entities.Modulo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ticket {
    private Long id;
    private String titulo;
    private Cliente codCliente;
    private Modulo codModulo;
    private Date dataAbertura;
    private Date dataEncerramento;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }
    public void setCodModulo(Modulo codModulo) {
        this.codModulo = codModulo;
    }
    
    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
}
