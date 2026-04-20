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

    public void fecharpedido(){
        Double total = 0.00;

        System.out.println("\n ----- Nota Fiscal! -----");
        System.out.printf("Comprador: %s\n\n", this.getCliente().getNome());
        System.out.println("Itens Comprados: ");

        for(int i=0; i<this.getItens().size(); i++){
            ItemPedido item = this.getItens().get(i);

            String nome = item.getProduto().getNomeItem();
            Integer qtd = item.getQuantidade();
            Double preco = item.getProduto().getPreco();

            System.out.printf("%dx  %s        %.2f\n", qtd, nome, preco*qtd);

            total += preco * qtd;
        }

        if(total>250){
            System.out.println("Frete: 0,00");
        } else{
            System.out.println("Frete: R$ 25,00");
            total += 25;
        }
        System.out.printf("\n\nTotal: %.2fR$\n", total);
        System.out.printf("UUID da compra: %s\n", this.getIdPedido());
        System.out.println("  ----- Fim! -----");

    }
}
