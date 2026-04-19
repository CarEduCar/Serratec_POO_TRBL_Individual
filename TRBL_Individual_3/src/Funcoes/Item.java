package Funcoes;
import java.util.UUID;

public class Item {
    final private UUID IDITEM;
    final private String NOMEITEM;
    private Integer estoque;

    public Item(UUID idItem, String NOME, Integer estoque) {
        this.IDITEM = idItem;
        this.NOMEITEM = NOME;
        this.estoque = estoque;
    }

    public UUID getIDITEM() {
        return this.IDITEM;
    }

    public String getNOMEITEM() {
        return this.NOMEITEM;
    }

    public Integer getEstoque() {
        return this.estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}

