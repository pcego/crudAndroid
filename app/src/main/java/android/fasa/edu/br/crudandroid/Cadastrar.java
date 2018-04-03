package android.fasa.edu.br.crudandroid;

import android.fasa.edu.br.Dao.ClienteDao;
import android.fasa.edu.br.Model.Cliente;
import android.fasa.edu.br.Util.Util;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastrar extends AppCompatActivity {

    private ClienteDao clienteDao;
    private Cliente cliente;
    private EditText nome;
    private EditText cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
    }

    public void salvar(View v){
        cliente = new Cliente();
        clienteDao = ClienteDao.getClienteDao(getApplicationContext());

        nome = (EditText) findViewById(R.id.edtNome);

        cpf = (EditText) findViewById(R.id.edtCpf);
        cliente.setNome(String.valueOf(nome.getText()));
        cliente.setCpf(String.valueOf(cpf.getText()));

        if(cliente.getNome().equals("") || cliente.getCpf().equals("")){

            Util.mensagemAviso("Cadastro de Cliente",
                    "Campo Nome e CPF devem ser Preenchidos", this);
        }


        else if(clienteDao.insert(cliente)){

            Toast.makeText(this,
                    "Cliente Gravado com Sucesso!",
                    Toast.LENGTH_LONG).show();

            nome.setText("");
            cpf.setText("");

        }

        else{
            Toast.makeText(this,
                    "Erro ao Gravar Cliente.",
                    Toast.LENGTH_LONG).show();
        }
    }
}
