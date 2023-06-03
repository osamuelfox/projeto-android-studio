package com.example.anotacao.controller;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.anotacao.model.Anotacoes;
import com.example.anotacao.view.MainActivity;

public class AnotacaoController {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCE = "pref_listavip";

    public AnotacaoController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCE,0);
        listaVip = preferences.edit();

    }

    @Override
    public String toString() {
        Log.d("MVC_controller", "Controller Iniciado");
        return super.toString();
    }

    public void salvar(Anotacoes outraAnotacoes){
        Log.d("MVP_MVC_controller", "Salvo: " + outraAnotacoes.toString());

        listaVip.putString("Titulo:", outraAnotacoes.getTitulo());
        listaVip.putString("Texto:", outraAnotacoes.getTexto());

        listaVip.apply();

    }

    public Anotacoes buscar(Anotacoes outraAnotacoes){
        outraAnotacoes.setTitulo(preferences.getString("Titulo:", ""));
        outraAnotacoes.setTexto(preferences.getString("Texto:", ""));

        return outraAnotacoes;

    }

    public void limpar(Anotacoes anotacoes){
        listaVip.clear();
        listaVip.apply();

    }
}
