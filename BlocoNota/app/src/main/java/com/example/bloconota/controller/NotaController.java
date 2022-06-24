package com.example.bloconota.controller;

import android.content.Context;

import com.example.bloconota.model.Nota;
import com.example.bloconota.model.NotaDAO;

import java.util.ArrayList;

public class NotaController {
    Context nContext;
    NotaDAO notaDAO;

    public NotaController(Context c) {
        nContext=c;
        notaDAO = new NotaDAO(c);
    }

    public Nota cadastrarNota(Nota n){
        return notaDAO.inserirNota(n);
    }

    public ArrayList<Nota> ListaNotas(){
        return notaDAO.getListaNotas();
    }

    public ArrayList<String> ListaTitulosNotas(){
        ArrayList<String> result = new ArrayList<String>();
        for (Nota nota: this.ListaNotas()
             ) {
            result.add(nota.getTitulo());
        }
        return result;
    }

    private class NotaDAO {
    }
}
