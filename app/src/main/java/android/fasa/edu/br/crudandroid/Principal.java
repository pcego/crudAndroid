package android.fasa.edu.br.crudandroid;

import android.content.Intent;
import android.fasa.edu.br.Dao.ClienteDao;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class Principal extends AppCompatActivity {
    Intent cad, listar, up, del;
    private ClienteDao clienteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void cadastrar(View view) {
        cad = new Intent(getApplicationContext(), Cadastrar.class);
        startActivity(cad);
    }


    public void listarTodos(View view) {
        listar = new Intent(getApplicationContext(), ListClienteActivity.class);
        startActivity(listar);
    }

    public void atualizar(View view) {
        up = new Intent(getApplicationContext(), Cadastrar.class);
        startActivity(up);
    }

    public void apagar(View view) {
        Bundle msg = new Bundle();
        msg.putString("apagar", "confirme");
        del = new Intent(getApplicationContext(), ListDelActivity.class);
        del.putExtras(msg);
        startActivity(del);
    }

    public void sair(View view) {
        finish();
    }
}
