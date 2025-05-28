package com.desafio.desafio.shared.useCases;

public interface IUseCase<I, O> {
    O execute(I input);
}
