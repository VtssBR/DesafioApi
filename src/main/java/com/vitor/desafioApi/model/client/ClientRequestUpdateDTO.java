package com.vitor.desafioApi.model.client;

import java.util.Optional;

public record ClientRequestUpdateDTO(
        Optional<String> nome,
        Optional<String> cpf,
        Optional<String> dataNascimento,
        Optional<String> endereco
) {}
