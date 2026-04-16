package br.ulbra.dao;

import br.ulbra.model.Usuario;
import java.util.List;

public interface UsuarioDAO {
    void salvar(Usuario usuario);
    List<Usuario> listar();
    Usuario buscarPorId(int id_usuario);
    void atualizar(Usuario usuario);
    void deletar(int id_usuario);
}
