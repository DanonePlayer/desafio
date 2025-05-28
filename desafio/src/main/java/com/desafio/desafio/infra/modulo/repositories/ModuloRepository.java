package com.desafio.desafio.infra.modulo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.desafio.desafio.domain.modulo.IModuloRepository;
import com.desafio.desafio.domain.modulo.entities.Modulo;
import com.desafio.desafio.infra.modulo.models.ModuloModel;

@Repository
public class ModuloRepository implements IModuloRepository{

    @Autowired
    private JPAModuloRepository jpaModuloRepository;

    @Override
    public List<Modulo> getByName(String nome) {
        List<ModuloModel> moduloModels = this.jpaModuloRepository.findByNome(nome);
        return moduloModels.stream()
                           .map(ModuloModel::toEntity)
                           .toList();
    }

    @Override
    public Modulo getById(Long id) {
        return this.jpaModuloRepository.findById(id)
                                       .map(ModuloModel::toEntity)
                                       .orElse(null);
    }

    @Override
    public Modulo create(Modulo modulo) {
        ModuloModel model = new ModuloModel(modulo);
        return this.jpaModuloRepository.save(model).toEntity();
    }

    @Override
    public Modulo update(Modulo modulo) {
        ModuloModel model = new ModuloModel(modulo);
        return this.jpaModuloRepository.save(model).toEntity();
    }

    @Override
    public void deleteById(Long id) {
        this.jpaModuloRepository.deleteById(id);
        
    }

    @Override
    public List<Modulo> getAll() {
        List<ModuloModel> moduloModels = this.jpaModuloRepository.findAll();
        return moduloModels.stream()
                           .map(ModuloModel::toEntity)
                           .toList();
    }

}
