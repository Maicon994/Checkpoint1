package br.ulbra.controller;

import br.ulbra.dao.ClienteDAOImpl;
import br.ulbra.model.Cliente;
import br.ulbra.model.Usuario;
import br.ulbra.service.ClienteService;
import java.time.LocalDate;
import java.util.List;

public class ClienteController {

    private ClienteService service;

    public ClienteController() {
        this.service = new ClienteService(new ClienteDAOImpl());
    }

    public String cadastrar(String cliente_nome, String cpf, LocalDate dataNasc) {
        try {
            Cliente cliente = new Cliente();
            cliente.setCliente_nome(cliente_nome);
            cliente.setCpf(cpf);
            cliente.setDataNasc(dataNasc);
            service.cadastrar(cliente);
            return  "Cliente cadastrado com sucesso";
        } catch (Exception e) {
            return "Erro:"+e.getMessage();
        }
    }
    public List <Cliente> listar() {
        return service.listar();
    }

    public String atualizar(int id, String cliente_nome, String cpf, LocalDate dataNasc) {
        try {
            Cliente cliente = new Cliente(id, cliente_nome, cpf, dataNasc);
            service.atualizar(cliente);
            return "Atualizado com sucesso";
        } catch (Exception e) {
            return  "Erro:"+e.getMessage();
        }
    }

    public String deletar(Long id) {
        try {
            service.deletar(id);
            return  "Deletado com sucesso";
        } catch (Exception e) {
            return "Erro:+"+e.getMessage();
        }
    }


    
}
