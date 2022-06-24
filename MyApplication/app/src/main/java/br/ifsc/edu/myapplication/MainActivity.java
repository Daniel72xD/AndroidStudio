package br.ifsc.edu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import br.ifsc.edu.myapplication.Contollers.NotaController;
import br.ifsc.edu.myapplication.Model.Nota;
import br.ifsc.edu.myapplication.View.NovaNotaActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    NotaController notaController;
    Button newNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newNoteButton = findViewById(R.id.newNote);
        newNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NovaNotaActivity.class);
                startActivity(intent);
            }
        });

        listView = findViewById(R.id.listView);
        notaController = new NotaController(this);
    }

    public void carregaListagemNotas() {
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                notaController.getListaTituloNota());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<Nota> notas = notaController.getListaNotas();
                Nota nota = notas.get(i);
                int idNota = nota.getId();


                Intent intent = new Intent(getApplicationContext(), NotaInfo.class);
                intent.putExtra("id_nota", idNota);
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                NotaController controller = new NotaController(getApplicationContext());
                ArrayList<Nota> notas = controller.getListaNotas();

                Nota nota = notas.get(position);
                int idNota = nota.getId();

                boolean notaExcluida = controller.deletaNota(idNota);

                if (notaExcluida) {
                    Toast.makeText(getApplicationContext(), "Nota " + nota.getTitulo() + " foi removido.", Toast.LENGTH_LONG).show();
                }

                adapter.remove(nota.getTitulo());
                adapter.notifyDataSetChanged();

                return true;
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        carregaListagemNotas();
    }
}
