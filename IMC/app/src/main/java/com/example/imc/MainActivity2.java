package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textPeso;
    TextView textAltura;
    TextView textImc;
    Double imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String valor1 = getIntent().getStringExtra("peso");
        String valor2 = getIntent().getStringExtra("altura");
        textPeso = (TextView) findViewById(R.id.textPeso);
        textPeso.setText(valor1);
        textAltura = (TextView) findViewById(R.id.textAltura);
        textAltura.setText(valor2);
        String Peso1 = textPeso.getText().toString();
        double peso = Double.parseDouble(Peso1);
        String Altura1 = textAltura.getText().toString();
        double altura = Double.parseDouble(Altura1);
        imc = (peso/(altura*altura));
        textImc = (TextView) findViewById(R.id.textImc);
        textImc.setText(String.format("%.2f",imc));

        ImageView image1 = findViewById(R.id.AbaixoPeso);
        ImageView image2 = findViewById(R.id.pesoNormal);
        ImageView image3 = findViewById(R.id.sobrepeso);
        ImageView image4 = findViewById(R.id.obesidade1);
        ImageView image5 = findViewById(R.id.obesidade2);
        ImageView image6 = findViewById(R.id.obesidade3);

        image1.setVisibility(View.INVISIBLE);
        image2.setVisibility(View.INVISIBLE);
        image3.setVisibility(View.INVISIBLE);
        image4.setVisibility(View.INVISIBLE);
        image5.setVisibility(View.INVISIBLE);
        image6.setVisibility(View.INVISIBLE);

        if(imc <= 18.5){
            image1.setVisibility(View.VISIBLE);
        }else
            if(imc > 18.5 & imc < 25){
                image2.setVisibility(View.VISIBLE);
            }else
                if(imc >= 25 & imc < 30){
                    image3.setVisibility(View.VISIBLE);
                }else
                    if(imc >= 30 & imc < 35){
                        image4.setVisibility(View.VISIBLE);
                    }else
                        if(imc >= 35 & imc < 40){
                            image5.setVisibility(View.VISIBLE);
                        }else
                            if(imc > 40){
                                image6.setVisibility(View.VISIBLE);
                            }
    }
}