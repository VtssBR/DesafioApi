package com.vitor.desafioApi.model.client;

import java.time.LocalDate;

import jakarta.validation.constraints.*;

public record ClientRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @Size(min = 14, max=14, message = "CPF invalido")
        String cpf,

        @PastOrPresent
        LocalDate dataNascimento,

        String endereco
 ){
}
