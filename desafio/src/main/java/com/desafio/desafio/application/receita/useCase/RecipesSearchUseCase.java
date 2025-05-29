package com.desafio.desafio.application.receita.useCase;

import com.desafio.desafio.application.receita.dtos.ForkifyResponseDTO;
import com.desafio.desafio.domain.receita.providers.IForkifyProvider;
import com.desafio.desafio.shared.useCases.IUseCase;

public class RecipesSearchUseCase implements IUseCase<String, ForkifyResponseDTO> {

    private IForkifyProvider providerForkify;

    public RecipesSearchUseCase(IForkifyProvider providerForkify) {
        this.providerForkify = providerForkify;
    }

    @Override
    public ForkifyResponseDTO execute(String prato) {
        return providerForkify.buscarReceitas(prato);
    }

}
