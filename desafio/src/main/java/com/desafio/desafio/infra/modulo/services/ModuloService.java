package com.desafio.desafio.infra.modulo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.desafio.application.modulo.dtos.ModuloDTO;
import com.desafio.desafio.application.modulo.useCases.GetAllModulosUseCase;
import com.desafio.desafio.infra.modulo.repositories.ModuloRepository;


@Service
public class ModuloService {
    private GetAllModulosUseCase getAllModulosUseCase;

    private ModuloRepository moduloRepository;

    public ModuloService(ModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
        this.getAllModulosUseCase = new GetAllModulosUseCase(moduloRepository);
    }

    public List<ModuloDTO> getAllModulos() {
        return getAllModulosUseCase.execute();
    }
}
