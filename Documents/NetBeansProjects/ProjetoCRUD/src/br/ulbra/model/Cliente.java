package br.ulbra.model;

import java.time.LocalDate;

public class Cliente {

    private int id;
    private String cliente_nome;
    private String cpf;
    private LocalDate dataNasc;

    public Cliente() {
    }

    public Cliente(int id, String cliente_nome, String cpf, LocalDate dataNasc) {
        this.id = id;
        this.cliente_nome = cliente_nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

}
