package com.example.anotacao.model;

public class Anotacoes {

    private String titulo;
    private String texto;

    public Anotacoes() {
    }

    public Anotacoes(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Anotacoes{" +
                "titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
