package Funcoes;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {
    final private UUID idPedido;
    final private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.idPedido = UUID.randomUUID();
        this.cliente = cliente;
    }

    public void adicionarItem(Item produto, Integer qtd){
        ItemPedido novoItem = new ItemPedido(produto, qtd);
        this.itens.add(novoItem);
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public UUID getIdPedido() {
        return this.idPedido;
    }

    public List<ItemPedido> getItens() {
        return this.itens;
    }
}
