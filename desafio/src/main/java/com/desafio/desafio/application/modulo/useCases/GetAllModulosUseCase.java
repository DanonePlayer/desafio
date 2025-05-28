package com.desafio.desafio.application.modulo.useCases;

import java.util.List;

import com.desafio.desafio.application.modulo.dtos.ModuloDTO;
import com.desafio.desafio.domain.modulo.IModuloRepository;
import com.desafio.desafio.domain.modulo.entities.Modulo;
import com.desafio.desafio.shared.useCases.IVoidUseCase;

public class GetAllModulosUseCase implements IVoidUseCase<List<ModuloDTO>> {
    private IModuloRepository moduloRepository;

    public GetAllModulosUseCase(IModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
    }

    @Override
    public List<ModuloDTO> execute() {
        List<Modulo> modulos = moduloRepository.getAll();
        
        return modulos.stream()
                .map(modulo -> new ModuloDTO(modulo.getId(), modulo.getNome()))
                .toList();
    }
    
}
