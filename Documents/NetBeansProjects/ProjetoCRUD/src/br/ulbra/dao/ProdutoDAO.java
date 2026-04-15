package br.ulbra.dao;

import br.ulbra.model.Produto;
import java.util.List;

public interface ProdutoDAO {
    void salvar(Produto produto);
    List<Produto> listar();
    Produto buscarPorId(int id);
    void atualizar(Produto produto);
    void deletar(int id);
}
