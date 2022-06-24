package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtPeso;
    EditText txtAltura;

    Button btCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         txtPeso = (EditText) findViewById(R.id.txtPeso);
         txtAltura = (EditText) findViewById(R.id.txtAltura);
         btCalcular = (Button) findViewById(R.id.btCalcular);
         btCalcular.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                 i.putExtra("peso", txtPeso.getText().toString());
                 i.putExtra("altura", txtAltura.getText().toString());
                 startActivity(i);
                 finish();
             }
         });

    }
}