package br.ulbra.dao;

import br.ulbra.model.Equipamento;
import java.util.List;

public interface EquipamentoDAO {
    void salvar(Equipamento equipamento);
    List<Equipamento> listar();
    Equipamento buscarPorId(int id_equipamento);
    void atualizar(Equipamento equipamento);
    void deletar(int id_equipamento);
}
