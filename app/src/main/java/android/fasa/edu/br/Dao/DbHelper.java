package android.fasa.edu.br.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by pcego on 30/03/18.
 */

public class DbHelper extends SQLiteOpenHelper {


    public DbHelper(Context context, String name,
                    SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {

            String sql_cliente = " CREATE TABLE "
                    + ClienteDao.NOME_TABELA + " ( " + ClienteDao.Coluna.ID
                    + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + ClienteDao.Coluna.NOME + " TEXT NOT NULL, "
                    + ClienteDao.Coluna.CPF + " TEXT NOT NULL);";

            sqLiteDatabase.execSQL(sql_cliente);

        } catch (Exception e) {
            Log.e("DbHelper", "Erro na criação da tabela cliente", e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
