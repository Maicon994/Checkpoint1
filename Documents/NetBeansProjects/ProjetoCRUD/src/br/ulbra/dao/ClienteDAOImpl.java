package br.ulbra.dao;

import br.ulbra.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    public ClienteDAOImpl() {

    }

    @Override
    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO cliente (cliente_nome, cpf, dataNasc) VALUES (?, ?, ?)";

        try (Connection conn = ConectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCliente_nome());
            stmt.setString(2, cliente.getCpf());
            stmt.setDate(3, java.sql.Date.valueOf(cliente.getDataNasc()));

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cliente> listar() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList<>();

        try (Connection conn = ConectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente u = new Cliente(
                        rs.getInt("id"),
                        rs.getString("cliente_nome"),
                        rs.getString("cpf"),
                        rs.getDate("dataNasc").toLocalDate()
                );
                lista.add(u);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";

        try (Connection conn = ConectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Cliente(
                        rs.getInt("id"),
                        rs.getString("cliente_nome"),
                        rs.getString("cpf"),
                        rs.getDate("dataNasc").toLocalDate()
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET cliente_nome = ?, cpf = ?, dataNasc = ? WHERE id = ?";

        try (Connection conn = ConectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCliente_nome());
            stmt.setString(2, cliente.getCpf());
            stmt.setDate(3, java.sql.Date.valueOf(cliente.getDataNasc()));
            stmt.setLong(4, cliente.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try (Connection conn = ConectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
