package br.ulbra.service;

import br.ulbra.dao.ProdutoDAO;
import br.ulbra.model.Produto;

import java.util.List;

public class ProdutoService {

    private ProdutoDAO dao;

    public ProdutoService(ProdutoDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Produto produto) {

        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            throw new RuntimeException("Nome obrigatório");
        }

        if (produto.getCodigoBarra() == null || produto.getCodigoBarra().isEmpty()) {
            throw new RuntimeException("Código de Barras obrigatório");
        }
        dao.salvar(produto);
    }

    public List<Produto> listar() {
        return dao.listar();
    }

    public void atualizar(Produto produto) {
        dao.atualizar(produto);
    }

    public void deletar(int id) {
        dao.deletar(id);
    }

    public Produto buscar(int id) {
        return dao.buscarPorId(id);
    }
}
