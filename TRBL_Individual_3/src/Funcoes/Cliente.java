package Funcoes;
import java.util.Date;
import java.util.UUID;

public class Cliente {

    final private UUID idCliente;
    private String nome;
    final private Date datanasc;
    final private String CPF;

    public Cliente(String nome, Date datanasc, String cpf) {
        this.idCliente = UUID.randomUUID();
        this.nome = nome;
        this.datanasc = datanasc;
        this.CPF = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getIdCliente() {
        return this.idCliente;
    }

    public String getNome() {
        return this.nome;
    }

    public Date getDatanasc() {
        return this.datanasc;
    }
}


