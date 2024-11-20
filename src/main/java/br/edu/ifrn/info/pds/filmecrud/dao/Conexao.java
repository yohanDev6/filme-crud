/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrn.info.pds.filmecrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author yohan
 */
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/filme_db";
    private static final String USUARIO = "root";
    private static final String SENHA = "DomainSys771.6";
    
    public static Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do banco de dados não encontrado.", e);
        }
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
    
    public static void desconectar(Connection conexao){
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar: " + e.getMessage());
            }
        }
    }
}
