package com.vitor.desafioApi.model.contact;


public record ContactRequestDTO(Integer clientId, String tipo, String valor, String observacao ) {
}

