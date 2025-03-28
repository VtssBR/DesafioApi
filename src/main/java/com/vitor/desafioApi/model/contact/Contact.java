package com.vitor.desafioApi.model.contact;

import com.vitor.desafioApi.model.client.Client;
import jakarta.persistence.*;

@Table(name = "contact")
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    private String tipo;
    private String valor;
    private String observacao;

    public Contact(){}

    public Contact(int id, Client client, String tipo, String valor, String observacao) {
        this.id = id;
        this.client = client;
        this.tipo = tipo;
        this.valor = valor;
        this.observacao = observacao;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public Client  getClient() { return client; }
    public void setClient(Client  client) { this.client = client; }

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getValor() {return valor;}
    public void setValor(String valor) {this.valor = valor;}

    public String getObservacao() {return observacao;}
    public void setObservacao(String observacao) {this.observacao = observacao;}

}
