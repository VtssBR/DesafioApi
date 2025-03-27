package com.vitor.desafioApi.model.client;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "client")
@Entity

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //equivalente ao serial
    private int id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String endereco;

    public Client() {}

    public Client(String nome, String cpf, LocalDate dataNascimento, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) {this.endereco = endereco;}
}
