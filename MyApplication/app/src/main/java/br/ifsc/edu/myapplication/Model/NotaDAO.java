package br.ifsc.edu.myapplication.Model;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

public class NotaDAO {
    private Context context;
    private SQLiteDatabase dataBase;
    private Button buttonExcluir;

    public NotaDAO(Context context) {
        this.context = context;
        dataBase = context.openOrCreateDatabase("NotaDb", Context.MODE_PRIVATE, null);
        dataBase.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, texto VARCHAR NOT NULL);");
    }

    public Nota criarNota(Nota nota) {
        ContentValues cv = new ContentValues();
        cv.put("titulo", nota.getTitulo());
        cv.put("texto", nota.getTexto());

        nota.setId((int) dataBase.insert("notas", null, cv));
        Log.d("valores", "" + Integer.toString(nota.getId()));

        return nota;
    }

    public boolean salvarNota(Nota nota) {
        ContentValues cv = new ContentValues();
        dataBase.update("notas", cv, "id = ?", new String[]{Long.toString(nota.getId())});
        return  true;
    }

    public boolean deleteNote(int idNota) {
        return dataBase.delete("notas", "id=?", new String[]{Integer.toString(idNota)}) > 0;
    }


    public ArrayList<Nota> getListaNotas() {
        Cursor cursor = dataBase.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        ArrayList<Nota> arrayListNotas = new ArrayList();
        while (!cursor.isAfterLast()) {
            Nota nota = new Nota(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            arrayListNotas.add(nota);
            cursor.moveToNext();
        }

        return arrayListNotas;
    }

    public Nota getNota(Integer idNota){
        Cursor cursor = dataBase.rawQuery("SELECT * FROM notas WHERE id=?", new String[]{Integer.toString(idNota)});
        cursor.moveToFirst();
        ArrayList<Nota> arrayListNotas = new ArrayList();
        while (!cursor.isAfterLast()) {
            Nota nota = new Nota(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            arrayListNotas.add(nota);
            cursor.moveToNext();
        }
        return arrayListNotas.get(0);
    }
}
