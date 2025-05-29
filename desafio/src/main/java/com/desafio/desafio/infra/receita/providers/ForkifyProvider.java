package com.desafio.desafio.infra.receita.providers;

import org.springframework.web.client.RestTemplate;

import com.desafio.desafio.application.receita.dtos.ForkifyResponseDTO;
import com.desafio.desafio.domain.receita.providers.IForkifyProvider;

public class ForkifyProvider implements IForkifyProvider {
    @Override
    public ForkifyResponseDTO buscarReceitas(String prato) {
        String url = "https://forkify-api.herokuapp.com/api/search?q=" + prato;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, ForkifyResponseDTO.class);
    }
}
