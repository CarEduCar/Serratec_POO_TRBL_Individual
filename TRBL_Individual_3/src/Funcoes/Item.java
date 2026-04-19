package Funcoes;
import java.util.UUID;

public class Item {
    final private UUID idItem;
    final private String nomeItem;
    private Double preco;
    private Integer estoque;

    public Item(String nome, Double preco, Integer estoque) {
        this.idItem = UUID.randomUUID();
        this.nomeItem = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public UUID getIdItem() {
        return this.idItem;
    }

    public String getNomeItem() {
        return this.nomeItem;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPreco() {
        return this.preco;
    }

    public Integer getEstoque() {
        return this.estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}

