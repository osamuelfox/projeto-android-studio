package com.example.imc.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.imc.database.IMC_BD;
import com.example.imc.model.Calculadora;
import com.example.imc.view.MainActivity;

public class ImcContoller extends IMC_BD {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public ImcContoller(MainActivity mainActivity){
        super(mainActivity);

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

    }

    @NonNull
    @Override

    public String toString(){
        Log.d("MVC_controller", "Controller Iniciado");
        return super.toString();
    }

    public void salvar(Calculadora outraCalculadora){

        ContentValues dados = new ContentValues();

        Log.d("MVP_MVC_controller", "Salvo: " + outraCalculadora.toString());
        listaVip.putString("Peso: ", "");
        listaVip.putString("Altura: ", "");
        listaVip.apply();

        dados.put("Peso", outraCalculadora.getPeso());
        dados.put("Altura", outraCalculadora.getAltura());
        dados.put("Resultado", outraCalculadora.getResultado());

        salvarObjeto("IMC",dados);
    }

    public Calculadora buscar(Calculadora outroCalculadora){
        outroCalculadora.setPeso(preferences.getString("Peso: ",""));
        outroCalculadora.setAltura(preferences.getString("Altura: ",""));
        return outroCalculadora;

    }
    public void limpar (){
        listaVip.clear();
        listaVip.apply();

    }

}


