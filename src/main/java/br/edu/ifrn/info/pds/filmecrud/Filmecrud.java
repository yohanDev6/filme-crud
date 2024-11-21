/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifrn.info.pds.filmecrud;

import br.edu.ifrn.info.pds.filmecrud.dao.FilmeDAO;
import br.edu.ifrn.info.pds.filmecrud.domain.Filme;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author yohan
 */
public class Filmecrud {

    public static void main(String[] args) {
        
        // Teste de inserção
        Filme f1 = new Filme("Universal", "Jorge", "Ação", 12, 7.1);
        Filme f2 = new Filme("Warner Bros", "Maria", "Drama", 14, 8.3);
        Filme f3 = new Filme("Pixar", "João", "Animação", 6, 9.0);
        Filme f4 = new Filme("Paramount", "Ana", "Comédia", 10, 6.5);
        Filme f5 = new Filme("Sony", "Carlos", "Terror", 16, 7.8);
        
        FilmeDAO filmeDAO = new FilmeDAO();
        
        try {
            if (filmeDAO.inserir(f1)) {
                System.out.println("Teste 1 passou");
            } else {
                System.out.println("Teste 1 falhou");
            }
            filmeDAO.inserir(f2);
            filmeDAO.inserir(f3);
            filmeDAO.inserir(f4);
            filmeDAO.inserir(f5);
        } catch (SQLException e) {
            System.out.println("Teste 1 falhou");
            System.out.println("Erro ao inserir o filme: " + e.getMessage());
        }
        
        // Teste de busca por id
        try {
            System.out.println(filmeDAO.buscarPorId(1).toString());
            System.out.println("Teste 2 passou");
        } catch (SQLException e) {
            System.out.println("Teste 2 falhou");
            System.out.println("Erro ao buscar o filme por id: " + e.getMessage());
        }
        
        // Teste de buscar todos os filmes
        try {
            ArrayList<Filme> filmes = (ArrayList<Filme>) filmeDAO.buscarTodos();
            if (!filmes.isEmpty()) {
                for (Filme filme : filmes) {
                    System.out.println(filme.toString());
                }
            }
            System.out.println("Teste 3 passou");
        } catch (SQLException e) {
            System.out.println("Teste 3 falhou");
            System.out.println("Erro ao buscar todos os filmes: " + e.getMessage());
        }
        
        // Teste de atualização
        f1.setId(1);
        f1.setAutor("Dolores");
        f1.setAvaliacao(8);
        
        try {
            if (filmeDAO.atualizar(f1)) {
                System.out.println("Teste 4 passou");
            } else {
                System.out.println("Teste 4 falhou");
            }
        } catch (SQLException e) {
            System.out.println("Teste 4 falhou");
            System.out.println("Erro ao atualizar o filme: " + e.getMessage());
        }
        
        // Teste de exclusão
        try {
            if (filmeDAO.deletar(f1.getId())) {
                System.out.println("Teste 5 passou");
            } else {
                System.out.println("Teste 5 falhou");
            }
            filmeDAO.deletar(f2.getId());
            filmeDAO.deletar(f3.getId());
            filmeDAO.deletar(f4.getId());
            filmeDAO.deletar(f5.getId());
        } catch (SQLException e) {
            System.out.println("Teste 5 falhou");
            System.out.println("Erro ao deletar o filme: " + e.getMessage());
        }
    }
}
