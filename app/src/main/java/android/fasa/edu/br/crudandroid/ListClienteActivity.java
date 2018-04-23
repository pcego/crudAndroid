package android.fasa.edu.br.crudandroid;

import android.fasa.edu.br.Dao.ClienteDao;
import android.fasa.edu.br.Model.Cliente;
import android.fasa.edu.br.adapter.BasicAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListClienteActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener{

    private ListView listaClientes;
    private List<Cliente> clientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_cliente);

        listaClientes = (ListView) findViewById(R.id.listClientes);
        clientes = new ArrayList<Cliente>();
        clientes = ClienteDao.getClienteDao(this).selecionaTodos();
        listaClientes.setAdapter(new BasicAdapter(this,clientes));
        listaClientes.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(getApplicationContext(),
                "Cliente Cadastrado",
                Toast.LENGTH_LONG).show();
    }
}
