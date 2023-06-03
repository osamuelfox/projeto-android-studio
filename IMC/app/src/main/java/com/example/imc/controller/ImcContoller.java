package com.example.imc.controller;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.imc.model.Calculadora;
import com.example.imc.view.MainActivity;

public class ImcContoller {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public ImcContoller(MainActivity mainActivity){

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
        Log.d("MVP_MVC_controller", "Salvo: " + outraCalculadora.toString());
        listaVip.putString("Peso: ", "");
        listaVip.putString("Altura: ", "");

        listaVip.apply();

    }

    public Calculadora buscar(Calculadora outroCalculadora){
        outroCalculadora.setPeso(preferences.getString("Peso: ",""));
        outroCalculadora.setAltura(preferences.getString("Altura: ",""));
        return outroCalculadora;

    }
    public void limpar ( Calculadora calculadora ){
        listaVip.clear();
        listaVip.apply();

    }





}


