package android.fasa.edu.br.Util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.fasa.edu.br.crudandroid.Cadastrar;
import android.util.Log;

/**
 * Created by pcego on 30/03/18.
 */

public class Util {

    /**
     * método para exibir avisos
     * @author Pcego
     * @param titulo do aviso
     * @param msg a ser exibida
     * @param contesto da aplicação
     * @since 1.0     */

    public static void mensagemAviso(String titulo, String msg,
                                      Context contesto) {
        AlertDialog.Builder mensagem = new AlertDialog.Builder(contesto);
        mensagem.setTitle(titulo);
        mensagem.setMessage(msg);
        mensagem.setNeutralButton("OK", null);
        mensagem.show();
    }

    /**
     * método para exibir alertas
     * @author Pcego
     * @param titulo do aviso
     * @param msg a ser exibida
     * @param contesto da aplicação
     * @since 1.0
     */

    public static void menssagemAlerta(String titulo, String msg,
                                       final Context contesto) {
        AlertDialog.Builder mensagem = new AlertDialog.Builder(contesto);
        mensagem.setTitle(titulo);
        mensagem.setMessage(msg);
        mensagem.setNeutralButton("Sair",new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                Runnable r = new Runnable() {

                    public void run() {

                        Intent i = new Intent(contesto,Cadastrar.class);
                        contesto.startActivity(i);

                    }
                };
            }

        });
        mensagem.show();
    }

}
