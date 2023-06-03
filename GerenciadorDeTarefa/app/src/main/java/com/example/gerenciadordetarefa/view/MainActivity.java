package com.example.gerenciadordetarefa.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gerenciadordetarefa.R;
import com.example.gerenciadordetarefa.controller.GerenciadorController;
import com.example.gerenciadordetarefa.model.Gerenciador;

public class MainActivity extends AppCompatActivity {

    Gerenciador gerenciador;
    Gerenciador outroGerenciador;

    GerenciadorController controller;

    EditText editTitulo;
    EditText editDescricao;
    EditText editHora;

    Button btnbuton_Limpar;
    Button btnbuton_Salvar;
    Button btnbuton_Finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new GerenciadorController(MainActivity.this);

        outroGerenciador = new Gerenciador();
        controller.buscar(outroGerenciador);

        editTitulo = findViewById(R.id.text_titulo);
        editDescricao = findViewById(R.id.text_descricao);
        editHora = findViewById(R.id.text_time);

        btnbuton_Limpar = findViewById(R.id.button_Limpar);
        btnbuton_Salvar = findViewById(R.id.button_Salvar);
        btnbuton_Finalizar = findViewById(R.id.button_Finalizar);

        editTitulo.setText(outroGerenciador.getTitulo());
        editDescricao.setText(outroGerenciador.getDescricao());
        editHora.setText(outroGerenciador.getHora());

        btnbuton_Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTitulo.setText("");
                editDescricao.setText("");
                editHora.setText("");
                controller.limpar();
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

                outroGerenciador.setTitulo(editTitulo.getText().toString());
                outroGerenciador.setDescricao(editDescricao.getText().toString());
                outroGerenciador.setHora(editHora.getText().toString());

                Toast.makeText(MainActivity.this, " Salvo ", Toast.LENGTH_SHORT).show();
                controller.salvar(outroGerenciador);
            }
        });

    }
}