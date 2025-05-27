package com.desafio.desafio.infra.cliente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafio.application.clientes.dtos.ClienteDTO;
import com.desafio.desafio.infra.cliente.services.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/list")
    public ResponseEntity<List<ClienteDTO>> getAll(){
        List<ClienteDTO> toReturn = clienteService.getAllClients();

        return new ResponseEntity<List<ClienteDTO>>(toReturn, HttpStatus.OK);
    }
    
}
