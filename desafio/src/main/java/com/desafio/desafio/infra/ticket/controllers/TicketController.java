package com.desafio.desafio.infra.ticket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafio.application.ticket.dtos.TicketDTO;
import com.desafio.desafio.application.ticket.dtos.TicketDTOListCustom;
import com.desafio.desafio.infra.ticket.services.TicketService;



@RestController
@RequestMapping("tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/list")
    public ResponseEntity<List<TicketDTO>> getAll(
        @RequestParam(required = false) boolean orderByClient,
        @RequestParam(required = false) boolean orderByModulo,
        @RequestParam(required = false) String mes,
        @RequestParam(required = false) String ano
    ) {
        TicketDTOListCustom ticketDTOListCustom = new TicketDTOListCustom(mes, ano, orderByClient, orderByModulo);
        List<TicketDTO> toReturn = ticketService.getAllTickets(ticketDTOListCustom);

        return new ResponseEntity<List<TicketDTO>>(toReturn, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
        TicketDTO createdTicket = ticketService.createTicket(ticketDTO);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }
    
}
