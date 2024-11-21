/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrn.info.pds.filmecrud.domain;

/**
 *
 * @author yohan
 */
public class Filme {
    private long id;
    private String nome, autor, genero;
    private int classificacao;
    private double avaliacao;
    
    public Filme() {
        
    }

    public Filme(long id, String nome, String autor, String genero, int classificacao, double avaliacao) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.classificacao = classificacao;
        this.avaliacao = avaliacao;
    }
    
    public Filme(String nome, String autor, String genero, int classificacao, double avaliacao) {
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.classificacao = classificacao;
        this.avaliacao = avaliacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome);
        return sb.toString();
    }
}
