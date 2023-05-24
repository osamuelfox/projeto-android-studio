package com.example.imc.model;

public class Pessoa {

    private String peso;
    private String altura;

    public Pessoa(){
    }

    public Pessoa(String peso, String altura) {

        this.peso = peso;
        this.altura = altura;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "altura='" + altura + '\'' +
                ", peso='" + peso + '\'' +
                '}';
    }
}
