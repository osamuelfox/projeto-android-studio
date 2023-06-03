package com.example.gerenciadordetarefa.model;

public class Gerenciador {

    private String titulo;
    private String descricao;
    private String hora;

    public Gerenciador() {
    }

    public Gerenciador(String titulo, String descricao, String hora) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.hora = hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Gerenciador{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}
