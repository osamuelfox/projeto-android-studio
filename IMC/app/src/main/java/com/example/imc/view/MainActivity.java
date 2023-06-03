package com.example.imc.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imc.R;
import com.example.imc.controller.ImcContoller;
import com.example.imc.model.Calculadora;

public class MainActivity extends AppCompatActivity {

    Calculadora calculadora;
    Calculadora outraCalculadora;

    ImcContoller controller;

    EditText edit_Peso;
    EditText edit_Altura;
    TextView text_Resultado;



    Button btnbuton_Limpar;
    Button btnbuton_Salvar;
    Button btnbuton_Finalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new ImcContoller(MainActivity.this);
        controller.toString();

        outraCalculadora = new Calculadora();
        controller.buscar(outraCalculadora);

        edit_Peso = findViewById(R.id.editPeso);
        edit_Altura = findViewById(R.id.editAltura);
        text_Resultado = findViewById(R.id.textResultado);

        btnbuton_Limpar = findViewById(R.id.button_Limpar);
        btnbuton_Salvar = findViewById(R.id.button_Salvar);
        btnbuton_Finalizar = findViewById(R.id.button_Finalizar);

        edit_Peso.setText(outraCalculadora.getPeso());
        edit_Altura.setText(outraCalculadora.getAltura());
        text_Resultado.setText(outraCalculadora.getResultado());

        btnbuton_Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_Peso.setText("");
                edit_Altura.setText("");

            }
        });

        btnbuton_Finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, " Volte ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnbuton_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                outraCalculadora.setPeso(edit_Peso.getText().toString());
                outraCalculadora.setAltura(edit_Altura.getText().toString());


                Toast.makeText(MainActivity.this, " Salvo ", Toast.LENGTH_SHORT).show();
                controller.salvar(outraCalculadora);

            }
        });



        Log.i("ProgramacaoPOO", outraCalculadora.toString());

    }

}