package com.vitor.desafioApi.model.contact;


import jakarta.validation.constraints.NotBlank;

public record ContactRequestDTO(
        Integer clientId,

        @NotBlank(message = "Selecione o Tipo de contato")
        String tipo,

        @NotBlank(message = "Insira o contato")
        String valor,

        String observacao ) {
}

