package com.vitor.desafioApi.model.client;

import java.time.LocalDate;

public record ClientRequestDTO(String nome, String cpf, LocalDate dataNascimento, String endereco) {
}
