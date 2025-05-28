package com.desafio.desafio.infra.modulo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafio.application.modulo.dtos.ModuloDTO;
import com.desafio.desafio.infra.modulo.services.ModuloService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("modulos")
public class ModuloController {
    @Autowired
    private ModuloService moduloService;

    @GetMapping("/list")
    public ResponseEntity<List<ModuloDTO>> getAll(){
        List<ModuloDTO> toReturn = moduloService.getAllModulos();

        return new ResponseEntity<List<ModuloDTO>>(toReturn, HttpStatus.OK);
    }
    
}
