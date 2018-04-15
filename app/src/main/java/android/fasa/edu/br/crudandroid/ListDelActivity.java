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
    private BasicAdapter listAdpter;
    private long id;
    private Intent it;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_delete_client);
        listAdpter = new BasicAdapter(this);
        it = getIntent();
        b = it.getExtras();

        listaClientes = (ListView) findViewById(R.id.listDelClientes);
        listaClientes.setAdapter(listAdpter);
        listaClientes.setOnItemClickListener(this);
    }

    //Método invocado pelo android quando um item da lista é clicado
    @Override
    public void onItemClick(final AdapterView<?> adapterView, View view, int i, long l) {

        id = l;

        if ( b.getString("apagar").equals("confirme") ) {

            //Gera uma caixa de diálogo
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            //define icone da caixa
            builder.setIcon(R.mipmap.usuario);
            //Define título da caixa
            builder.setTitle("Confirme");
            //mensagem a ser exibida na caixa
            builder.setMessage("Deseja Realemente Deletar?");
            //trata o evento de clique no botão sim
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
            //Trata evento de clique no botão não
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
