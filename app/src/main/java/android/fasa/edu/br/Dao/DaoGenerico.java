package android.fasa.edu.br.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by pcego on 30/03/18.
 */
public abstract class DaoGenerico<T> {

    /*
	 * declaração variáveis bd
	 */
    private static String NOME_DB = "cliente";
    private int VERSAO_DB = 1;
    private Context context;
    private DbHelper dbHelper;

    /**
     * @author Paulo César
     * @since 1.0
     * @version 1.0
     * @return Retorna uma lista contendo todos os dados
     * gravados no bd
     */
    public abstract List<T> selecionaTodos();


    public abstract T selecionaPorId(int i);


    public abstract boolean insert(T o);


    public abstract void delete(int i);


    public abstract void update(T o);


    protected DaoGenerico(Context context){
        this.context = context;
        dbHelper = new DbHelper(context, NOME_DB, null, VERSAO_DB);

    }


    protected SQLiteDatabase getDb(){
        return dbHelper.getWritableDatabase();
    }
}
