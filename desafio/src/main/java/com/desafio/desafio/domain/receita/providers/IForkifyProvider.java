package com.desafio.desafio.domain.receita.providers;

import com.desafio.desafio.application.receita.dtos.ForkifyResponseDTO;

public interface IForkifyProvider {
    ForkifyResponseDTO buscarReceitas(String prato);
}
