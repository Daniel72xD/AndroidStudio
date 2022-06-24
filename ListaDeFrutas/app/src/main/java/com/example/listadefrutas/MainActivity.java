package com.example.listadefrutas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String dataSet[];
    ListView list;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataSet = new String[] {"Abacate", "Banana", "Carambola" , "Damasco" , "Escropari", "Figo", "Goiaba", "Melão", "Uva", "Pera", "Melancia", "Bergamota", "Kiwi", "Cacau","Abacaxi"};
        list = findViewById(R.id.list);
        adapter = new ArrayAdapter( getApplicationContext(),R.layout.item_lista,R.id.textView, dataSet);
        list.setAdapter(adapter);

    }
}