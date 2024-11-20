/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrn.info.pds.filmecrud.dao;

import br.edu.ifrn.info.pds.filmecrud.domain.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yohan
 */
public class FilmeDAO {

    public boolean inserir(Filme filme) throws SQLException {
        String sql = "INSERT INTO filmes (nome, autor, genero, classificacao, avaliacao) VALUES (?,?,?,?,?);";
        boolean resultado = false;

        Connection conexao = Conexao.conectar();

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, filme.getNome());
            comando.setString(2, filme.getAutor());
            comando.setString(3, filme.getGenero());
            comando.setInt(4, filme.getClassificacao());
            comando.setDouble(5, filme.getAvaliacao());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o filme: " + e.getMessage());
        } finally {
            Conexao.desconectar(conexao);
        }
        return resultado;
    }

    public boolean atualizar(Filme filmeAtualizado) throws SQLException {
        String sql = "UPDATE filmes SET nome = ?, autor = ?, genero = ?, classificacao = ?, avaliacao = ? WHERE id = ?;";
        boolean resultado = false;

        Connection conexao = Conexao.conectar();

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, filmeAtualizado.getNome());
            comando.setString(2, filmeAtualizado.getAutor());
            comando.setString(3, filmeAtualizado.getGenero());
            comando.setInt(4, filmeAtualizado.getClassificacao());
            comando.setDouble(5, filmeAtualizado.getAvaliacao());
            comando.setLong(6, filmeAtualizado.getId());

            int linhasAfetadas = comando.executeUpdate();
            if (linhasAfetadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o filme: " + e.getMessage());
        } finally {
            Conexao.desconectar(conexao);
        }
        return resultado;
    }

    public boolean deletar(long id) throws SQLException {
        String sql = "DELETE FROM filmes WHERE id = ?;";
        boolean resultado = false;

        Connection conexao = Conexao.conectar();

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setLong(1, id);

            int linhasAfetadas = comando.executeUpdate();
            if (linhasAfetadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o filme: " + e.getMessage());
        } finally {
            Conexao.desconectar(conexao);
        }
        return resultado;
    }

    // Buscar filme por id
    public Filme buscarPorId(long id) throws SQLException {
        String sql = "SELECT * FROM filmes WHERE id = ?;";
        Filme filme = null;

        Connection conexao = Conexao.conectar();

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setLong(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                filme = new Filme(
                        resultado.getLong("id"),
                        resultado.getString("nome"),
                        resultado.getString("autor"),
                        resultado.getString("genero"),
                        resultado.getInt("classificacao"),
                        resultado.getDouble("avaliacao")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o filme por ID: " + e.getMessage());
        } finally {
            Conexao.desconectar(conexao);
        }

        return filme;
    }

    // Buscar todos os filmes
    public ArrayList<Filme> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM filmes;";
        ArrayList<Filme> filmes = new ArrayList<>();

        Connection conexao = Conexao.conectar();

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Filme filme = new Filme(
                        resultado.getLong("id"),
                        resultado.getString("nome"),
                        resultado.getString("autor"),
                        resultado.getString("genero"),
                        resultado.getInt("classificacao"),
                        resultado.getDouble("avaliacao")
                );
                filmes.add(filme);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os filmes: " + e.getMessage());
        } finally {
            Conexao.desconectar(conexao);
        }

        return filmes;
    }
}
