package com.desafio.desafio.infra.receita.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafio.application.receita.dtos.ForkifyResponseDTO;
import com.desafio.desafio.infra.receita.services.ReceitaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    
    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public ResponseEntity<ForkifyResponseDTO> getReceitas(@RequestParam String prato) {
        ForkifyResponseDTO response = receitaService.buscarReceitas(prato);
        return ResponseEntity.ok(response);
    }

}
