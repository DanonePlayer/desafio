package com.desafio.desafio.infra.receita.services;

import org.springframework.stereotype.Service;

import com.desafio.desafio.application.receita.dtos.ForkifyResponseDTO;
import com.desafio.desafio.application.receita.useCase.RecipesSearchUseCase;
import com.desafio.desafio.infra.receita.providers.ForkifyProvider;

@Service
public class ReceitaService {

    private ForkifyProvider forkifyProvider;
    private RecipesSearchUseCase recipesSearchUseCase;

    public ReceitaService() {
        this.forkifyProvider = new ForkifyProvider();
        this.recipesSearchUseCase = new RecipesSearchUseCase(forkifyProvider);
    }

    public ForkifyResponseDTO buscarReceitas(String prato) {
        return recipesSearchUseCase.execute(prato);
    }

}
