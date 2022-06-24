package com.example.bloconota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bloconota.controller.NotaController;
import com.example.bloconota.model.Nota;

public class ActivityExibirNota extends AppCompatActivity {

    NotaController notaController;
    EditText edTitulo, edText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_nota);

        notaController = new NotaController(getApplicationContext());
        edTitulo = findViewById(R.id.edTitulo);
        edText = findViewById(R.id.edTexto);
    }

    public void salvarNota(View v){
        Nota n = notaController.cadastrarNota(new Nota(edTitulo.getText().toString(), edText.getText().toString()));
        Toast.makeText(this, Integer.toString(n.getId()),Toast.LENGTH_SHORT).show();
    }


}