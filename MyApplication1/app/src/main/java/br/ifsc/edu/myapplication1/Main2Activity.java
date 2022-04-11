package br.ifsc.edu.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textRecebe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textRecebe = (TextView) findViewById(R.id.textRecebe);
        String valor = getIntent().getStringExtra("key");
        textRecebe.setText(valor);
    }
}
