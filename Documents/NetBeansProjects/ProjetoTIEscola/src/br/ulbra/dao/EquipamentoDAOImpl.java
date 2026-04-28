package br.ulbra.dao;

import br.ulbra.model.Equipamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EquipamentoDAOImpl implements EquipamentoDAO {

    @Override
    public void salvar(Equipamento equipamento) {
        String sql = "INSERT INTO equipamento (tag_patrimonio, tipo, sala) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getTagPatrimonio());
            stmt.setString(2, equipamento.getTipo());
            stmt.setString(3, equipamento.getSala());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Equipamento cadastrado com sucesso!");

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar equipamento: " + e.getMessage());
        }
    }

    public List<Equipamento> listarTodos() {

        String sql = "SELECT id_equipamento, tag_patrimonio FROM equipamento ORDER BY tag_patrimonio";

        List<Equipamento> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Equipamento e = new Equipamento();

                e.setIdEquipamento(rs.getInt("id_equipamento"));
                e.setTagPatrimonio(rs.getString("tag_patrimonio"));

                lista.add(e);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    @Override
    public Equipamento buscarPorId(int id) {
        String sql = "SELECT * FROM equipamento WHERE id_equipamento = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Equipamento e = new Equipamento();
                    e.setIdEquipamento(rs.getInt("id_equipamento"));
                    e.setTagPatrimonio(rs.getString("tag_patrimonio"));
                    e.setTipo(rs.getString("tipo"));
                    e.setSala(rs.getString("sala"));
                    return e;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar equipamento: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void atualizar(Equipamento equipamento) {
        String sql = "UPDATE equipamento SET tag_patrimonio = ?, tipo = ?, sala = ? WHERE id_equipamento = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getTagPatrimonio());
            stmt.setString(2, equipamento.getTipo());
            stmt.setString(3, equipamento.getSala());
            stmt.setInt(4, equipamento.getIdEquipamento());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Equipamento atualizado com sucesso!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM equipamento WHERE id_equipamento = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Equipamento removido!");

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar equipamento: " + e.getMessage());
        }
    }

    @Override
    public List<Equipamento> listar() {
        String sql = "SELECT * FROM equipamento ORDER BY tag_patrimonio";
        List<Equipamento> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Equipamento e = new Equipamento();
                e.setIdEquipamento(rs.getInt("id_equipamento"));
                e.setTagPatrimonio(rs.getString("tag_patrimonio"));
                e.setTipo(rs.getString("tipo"));
                e.setSala(rs.getString("sala"));
                lista.add(e);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar equipamentos: " + e.getMessage());
        }

        return lista;
    }
}