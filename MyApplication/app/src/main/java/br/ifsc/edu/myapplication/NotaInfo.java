package br.ifsc.edu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import br.ifsc.edu.myapplication.Contollers.NotaController;
import br.ifsc.edu.myapplication.Model.Nota;

public class NotaInfo extends AppCompatActivity {
    EditText editText;
    private Nota nota;
    private NotaController notaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao_nota);
        editText = findViewById(R.id.etText);
        notaController=new NotaController(getApplicationContext());
        Bundle bundle = getIntent().getExtras();

        int idNota = bundle.getInt("id_nota");
        if (idNota != 0)
            loadNote(idNota);
    }
    private void loadNote(int idNota) {
        nota = notaController.getNota(idNota);
        editText.setText(nota.getTexto());
    }


}
