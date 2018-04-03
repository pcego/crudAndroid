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

public class BasicAdapter extends BaseAdapter{

    private Context context;
    private List<Cliente> clientes = new ArrayList<>();
    private ClienteDao clienteDao;

    public BasicAdapter(Context context){
        super();
        this.context = context;
        clienteDao = ClienteDao.getClienteDao(context);
        clientes = clienteDao.selecionaTodos();
    }
    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int position) {
        return clientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return clientes.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        TextView txtCliente = new TextView(context);
        float dip = 50;
        float densidade = context.getResources().getDisplayMetrics().density;
        int px = (int) (dip * densidade + 0.5f);
        txtCliente.setHeight(px);
        txtCliente.setText(clientes.get(position).getNome());

        return txtCliente;
    }
}
