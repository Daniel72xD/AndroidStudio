package com.example.bloconota.model;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NotaDAO {
    public SQLiteDatabase database;
    public ArrayList<Integer> arrayIds;
    public ListView listView;

    public NotaDAO(Context c) {
        database = c.openOrCreateDatabase("dbNotas", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS notas(id INTEGER PRIMARY KEY AUTOINCREMENT, titulo varchar, texto varchar);");
    }
    public Nota inserirNota(Nota n){
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", n.getTitulo());
        contentValues.put("texto", n.getTexto());
        int i = (int) database.insert("notas", null, contentValues);
        n.setId(i);
        return n;
    }

    public ArrayList<Nota> getListaNotas() {

        Cursor cursor = database.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        ArrayList<Nota> arrayList = new ArrayList<>();

        while (!cursor.isAfterLast()){
            Nota n = new Nota(cursor.getInt(0), cursor.getString(1),cursor.getString(2));
            arrayList.add(n);
            cursor.moveToNext();
        }
        return arrayList;
    }

    public void ListaNotas(View v){
        try {
            arrayIds = new ArrayList<>();
            database = openOrCreateDatabase("dbNotas", MODE_PRIVATE, null);
            Cursor meuCursor = database.rawQuery("SELECT id, nome FROM notas", null);
            ArrayList<String> linhas = new ArrayList<String>();
            ArrayAdapter meuAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, linhas);
            listView.setAdapter(meuAdapter);
            meuCursor.moveToFirst();
            while(meuCursor!=null){
                linhas.add(meuCursor.getString(1));
                arrayIds.add(meuCursor.getInt(0));
                meuCursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        }
    }

