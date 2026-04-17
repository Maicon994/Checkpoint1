package br.ulbra.service;

import br.ulbra.dao.ChamadoDAO;
import br.ulbra.model.Chamado;

import java.util.List;

public class ChamadoService {

    private ChamadoDAO dao;

    public ChamadoService(ChamadoDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Chamado chamado) {

        if (chamado.getUsuario() == null) {
            throw new RuntimeException("Usuário obrigatório");
        }

        if (chamado.getEquipamento() == null) {
            throw new RuntimeException("Equipamento obrigatório");
        }
        if (chamado.getProblemaRelatado() == null || chamado.getProblemaRelatado().isEmpty()) {
            throw new RuntimeException("O problema relatado é obrigatório iiii];)'");
        }
        dao.salvar(chamado);
    }

    public List<Chamado> listar() {
        return dao.listar();
    }

    public void atualizar(Chamado chamado) {
        dao.atualizar(chamado);
    }

    public void deletar(int id) {
        dao.deletar(id);
    }

    public Chamado buscar(int id) {
        return dao.buscarPorId(id);
    }
}
