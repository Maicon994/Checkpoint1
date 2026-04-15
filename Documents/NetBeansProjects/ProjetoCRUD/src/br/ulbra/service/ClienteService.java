package br.ulbra.service;

import br.ulbra.dao.ClienteDAO;
import br.ulbra.model.Cliente;

import java.util.List;

public class ClienteService {

    private ClienteDAO dao;

    public ClienteService(ClienteDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Cliente cliente) {

        if (cliente.getCliente_nome() == null || cliente.getCliente_nome().isEmpty()) {
            throw new RuntimeException("Nome obrigatório");
        }

        if (cliente.getCpf() == null) {
            throw new RuntimeException("CPF inválido");
        }
         if (cliente.getDataNasc() == null) {
            throw new RuntimeException("Data inválida");
        }
        dao.salvar(cliente);
    }

    public List<Cliente> listar() {
        return dao.listar();
    }

    public void atualizar(Cliente cliente) {
        dao.atualizar(cliente);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }

    public Cliente buscar(Long id) {
        return dao.buscarPorId(id);
    }
}
