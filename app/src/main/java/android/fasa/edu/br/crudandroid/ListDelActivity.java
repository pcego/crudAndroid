package android.fasa.edu.br.crudandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.fasa.edu.br.Dao.ClienteDao;
import android.fasa.edu.br.adapter.BasicAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListDelActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener{

    private ListView listaClientes;
    private long id;
    private Intent it;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_delete_client);
        it = getIntent();
        b = it.getExtras();

        listaClientes = (ListView) findViewById(R.id.listDelClientes);
        listaClientes.setAdapter(new BasicAdapter(this));
        listaClientes.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        id = l;

        if ( b.getString("apagar").equals("confirme") ) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.mipmap.usuario);
            builder.setTitle("Confirme");
            builder.setMessage("Deseja Realemente Deletar?");
            builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    ClienteDao.getClienteDao(getApplicationContext()).delete((int)id);
                    Toast.makeText(getApplicationContext(),
                            "Cliente Deletado Com Sucesso!!",
                            Toast.LENGTH_LONG).show();
                    return;

                }
            });

            builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    return;
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        }
    }
}
