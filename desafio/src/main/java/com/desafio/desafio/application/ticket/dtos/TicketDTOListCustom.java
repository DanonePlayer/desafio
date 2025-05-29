package com.desafio.desafio.application.ticket.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketDTOListCustom {
    @JsonIgnore
    private String mes;
    @JsonIgnore
    private String ano;
    @JsonIgnore
    private boolean orderByClient;
    @JsonIgnore
    private boolean orderByModule;
}
