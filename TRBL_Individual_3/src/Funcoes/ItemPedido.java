package Funcoes;

import java.util.UUID;

public class ItemPedido {
    final private Item produto;
    private Integer qtd;

    public ItemPedido(Item Produto, Integer qtd) {
        this.produto = Produto;
        this.qtd = qtd;
    }

    public Item getProduto() {
        return this.produto;
    }

    public Integer getQuantidade() {
        return this.qtd;
    }
}

