package com.example.gerenciadordetarefa.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.gerenciadordetarefa.model.Gerenciador;
import com.example.gerenciadordetarefa.view.MainActivity;

public class GerenciadorController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public GerenciadorController(MainActivity mainActivity){

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_controller", "Controller Iniciado");
        return super.toString();
    }

    public void salvar(Gerenciador outraGerenciador) {

        Log.d("MVP_MVC_controller", "Salvo: " + outraGerenciador.toString());

        listaVip.putString("Titulo", outraGerenciador.getTitulo());
        listaVip.putString("Descricao", outraGerenciador.getDescricao());
        listaVip.putString("hora", outraGerenciador.getHora());
        listaVip.apply();
    }


    public Gerenciador buscar(Gerenciador outraGerenciador){
        outraGerenciador.setTitulo(preferences.getString("Titulo", ""));
        outraGerenciador.setDescricao(preferences.getString("Descricao", ""));
        outraGerenciador.setHora(preferences.getString("Hora", ""));

        return outraGerenciador;
    }

    public void limpar (){
        listaVip.clear();
        listaVip.apply();
    }
}
