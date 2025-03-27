package com.vitor.desafioApi.model.client;

import java.time.LocalDate;

public record ClientResponseDTO(Integer id, String nome, String cpf, LocalDate dataNascimento, String endereco) {
}
