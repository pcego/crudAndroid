package android.fasa.edu.br.Model;

/**
 * Created by pcego on 28/03/18.
 */

public class Cliente {

    private int id;
    private String nome = "";
    private String cpf = "";

    public Cliente(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}


}
