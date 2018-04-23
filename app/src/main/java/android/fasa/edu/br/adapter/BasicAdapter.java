package android.fasa.edu.br.adapter;

import android.content.Context;
import android.fasa.edu.br.Dao.ClienteDao;
import android.fasa.edu.br.Model.Cliente;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pcego on 30/03/18.
 */

// Classe para criar um adapter simples para ListView
public class BasicAdapter extends BaseAdapter{

    private Context context;
    //List para armazenar objetos Cliente
    private List<Cliente> clientes = new ArrayList<>();

    private ClienteDao clienteDao;

    // Construtor da classe recebendo o contexto e um list carregado
    public BasicAdapter(Context context, List<Cliente> clientes){
        super();
        this.context = context;
        this.clientes = clientes;
    }

    //Método subscrito da classe BaseAdapter
    //Retorna a quantidade de elementos no array
    @Override
    public int getCount() {
        return clientes.size();
    }

    //Método subscrito da classe BaseAdapter
    //Retorna um objeto da posição informada no parametro position
    @Override
    public Object getItem(int position) {
        return clientes.get(position);
    }

    //Método subscrito da classe BaseAdapter
    //Retorna um long referente ao id do objeto na base de dados
    @Override
    public long getItemId(int position) {
        return clientes.get(position).getId();
    }

    //Método subscrito da classe BaseAdapter
    //Retorna uma objeto view
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        TextView txtCliente = new TextView(context);
        float dip = 50;
        float densidade = context.getResources().getDisplayMetrics().density;
        int px = (int) (dip * densidade + 0.5f);
        txtCliente.setHeight(px);
        // texto que irá aparecer em cada elemento do ListView
        txtCliente.setText(clientes.get(position).getNome());

        return txtCliente;
    }
}
