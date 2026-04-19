package Funcoes;

import java.util.UUID;

public class ItemPedido {
    final private Item PRODUTO;
    private Integer qtd;

    public ItemPedido(Item Produto, Integer qtd) {
        this.PRODUTO = Produto;
        this.qtd = qtd;
    }

    public Item getPRODUTO() {
        return this.PRODUTO;
    }

    public Integer getQuantidade() {
        return this.qtd;
    }

    public void setQuantidade(Integer quantidade) {
        this.qtd = quantidade;
    }

}

