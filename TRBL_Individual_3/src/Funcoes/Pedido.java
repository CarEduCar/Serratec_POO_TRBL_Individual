package Funcoes;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {
    final private UUID IDPEDIDO;
    final private Cliente CLIENTE;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(UUID idPedido, Cliente idCliente) {
        this.IDPEDIDO = idPedido;
        this.CLIENTE = idCliente;
    }

    public void adicionarItem(Item produto, Integer qtd){
        ItemPedido novoItem = new ItemPedido(produto, qtd);
        this.itens.add(novoItem);
    }

    public Cliente getCLIENTE() {
        return this.CLIENTE;
    }

    public UUID getIdPedido() {
        return this.IDPEDIDO;
    }

    public List<ItemPedido> getItens() {
        return this.itens;
    }
}
