package br.ulbra.dao;

import br.ulbra.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAO {

    public ProdutoDAOImpl() {

    }

    @Override
    public void salvar(Produto produto) {
        String sql = "INSERT INTO produto (nome, codigoBarra, quantidade, preco, categoria, ativo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCodigoBarra());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());
            stmt.setString(5, produto.getCategoria());
            stmt.setBoolean(6, produto.getAtivo());
            
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Produto> listar() {
        String sql = "SELECT * FROM produto";
        List<Produto> lista = new ArrayList<>();

        try (Connection conn = ConectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto u = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("codigoBarra"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco"),
                        rs.getString("categoria"),
                        rs.getBoolean("ativo")
                );
                lista.add(u);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    @Override
    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";

        try (Connection conn = ConectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("codigoBarra"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco"),
                        rs.getString("categoria"),
                        rs.getBoolean("ativo")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void atualizar(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, codigoBarra = ?, quantidade = ?, preco = ?, categoria = ?, ativo = ?   WHERE id = ?";

        try (Connection conn = ConectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCodigoBarra());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());
            stmt.setString(5, produto.getCategoria());
            stmt.setBoolean(6, produto.getAtivo());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection conn = ConectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
