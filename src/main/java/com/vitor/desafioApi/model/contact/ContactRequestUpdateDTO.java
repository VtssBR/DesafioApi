package com.vitor.desafioApi.model.contact;


import java.util.Optional;

public record ContactRequestUpdateDTO(
        Optional<String> tipo,
        Optional<String> valor,
        Optional<String> observacao
) {
}
