package br.ulbra.model;

public class Produto {

    private int id;
    private String nome;
    private String codigoBarra;
    private int quantidade;
    private double preco;
    private String categoria;
    private boolean ativo;

    public Produto() {
    }

    public Produto(int id, String nome, String codigoBarra,
            int quantidade, double preco, String categoria, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.codigoBarra = codigoBarra;
        this.quantidade = quantidade;
        this.preco = preco;
        this.categoria = categoria;
        this.ativo = ativo;
    }

    

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
