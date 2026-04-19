package Funcoes;
import java.util.Date;
import java.util.UUID;

public class Cliente {

    final private UUID IDCLIENTE;
    private String nome;
    final private Date DATANASC;

    public Cliente(UUID idCliente, String nome, Date datanasc) {
        this.IDCLIENTE = idCliente;
        this.nome = nome;
        this.DATANASC = datanasc;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getIDCLIENTE() {
        return this.IDCLIENTE;
    }

    public String getNome() {
        return this.nome;
    }

    public Date getDatanasc() {
        return this.DATANASC;
    }
}


