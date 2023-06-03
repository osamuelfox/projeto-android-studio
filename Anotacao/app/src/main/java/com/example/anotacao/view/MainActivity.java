package com.example.anotacao.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anotacao.R;
import com.example.anotacao.controller.AnotacaoController;
import com.example.anotacao.model.Anotacoes;

public class MainActivity extends AppCompatActivity {

    Anotacoes anotacoes;
    Anotacoes outraAnotacoes;

    AnotacaoController controller;

    EditText editTitulo;
    EditText editTexto;

    Button button_flutuante_limpar;
    Button button_flutuante_finalizar;
    Button button_flutuante_salvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new AnotacaoController(MainActivity.this);
        controller.toString();

        outraAnotacoes = new Anotacoes();
        controller.buscar(outraAnotacoes);

        editTitulo = findViewById(R.id.text_Titulo_notas);
        editTexto = findViewById(R.id.text_Texto_notas);

        button_flutuante_salvar = findViewById(R.id.button_flutuante_salvar);
        button_flutuante_finalizar = findViewById(R.id.button_flutuante_finalizar);
        button_flutuante_limpar = findViewById(R.id.button_flutuante_limpar);

        editTitulo.setText(outraAnotacoes.getTitulo());
        editTexto.setText(outraAnotacoes.getTexto());

        button_flutuante_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTitulo.setText("");
                editTexto.setText("");
            }
        });

        button_flutuante_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, " Volte ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        button_flutuante_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                outraAnotacoes.setTitulo(editTitulo.getText().toString());
                outraAnotacoes.setTexto(editTexto.getText().toString());

                Toast.makeText(MainActivity.this, " Salvo ", Toast.LENGTH_SHORT).show();
                controller.salvar(outraAnotacoes);

            }
        });

        Log.i("ProgramacaoPOO", outraAnotacoes.toString());

    }
}