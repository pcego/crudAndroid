package android.fasa.edu.br.crudandroid;

import android.fasa.edu.br.adapter.BasicAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListClienteActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener{

    private ListView listaClientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_cliente);

        listaClientes = (ListView) findViewById(R.id.listClientes);
        listaClientes.setAdapter(new BasicAdapter(this));
        listaClientes.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(getApplicationContext(),
                "Cliente Cadastrado",
                Toast.LENGTH_LONG).show();
    }
}
