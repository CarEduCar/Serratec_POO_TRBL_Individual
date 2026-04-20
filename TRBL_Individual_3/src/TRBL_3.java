import Funcoes.Cliente;
import Funcoes.Item;
import Funcoes.Pedido;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TRBL_3 {

    public static void main(String[] args) throws InterruptedException {

        SimpleDateFormat dataBrasil = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        Cliente cliente;
        List<Item> estoqueDaLoja = new ArrayList<>();

        estoqueDaLoja.add(new Item("Kit de Dados Azuis", 21.90, 50));
        estoqueDaLoja.add(new Item("Carta Premium GITCG", 16.90, 80));
        estoqueDaLoja.add(new Item("Mesinha de Madeira", 129.90, 21));
        estoqueDaLoja.add(new Item("Super Mesa 4000", 1597.90, 2));

        System.out.println("Iniciando cadastro!");
        while(true){
            try{
                System.out.print("Digite o nome do usuario: ");
                String nome = sc.nextLine();

                System.out.print("\nDigite a data de nasc (ex: 15/05/1990): ");
                String datanascTemp = sc.nextLine();
                Date datanasc = dataBrasil.parse(datanascTemp);

                System.out.print("\nDigite o seu CPF : ");
                String cpf = sc.nextLine();

                cliente = new Cliente(nome, datanasc, cpf);

                break;  //condição de para do while
            }
            catch (InputMismatchException e){
                System.out.println("Valor inválido de entrada! Tente novamente\n");
            } catch (ParseException e) {
                System.out.println("Erro: Formato de data inválido! \n\n");
            }
        }

        Pedido pedido = new Pedido(cliente);

            do{
                try {
                    Integer opc;
                    Item produto;

                    System.out.printf("Olá %s!", cliente.getNome());

                    for (int i = 0; i < estoqueDaLoja.size(); i++) {
                        produto = estoqueDaLoja.get(i);

                        System.out.printf("\n\nItem %d\n%s\nValor: %.2f\nEstoque: %d", i + 1, produto.getNomeItem(), produto.getPreco(), produto.getEstoque());
                    }

                    System.out.print("\n\nSelecione qual item deseja comprar! (Digite 0 para encerrar as compras): ");
                    opc = sc.nextInt() - 1;

                    if (opc <= -1) {
                        break;  // sair do while
                    }

                    produto = estoqueDaLoja.get(opc);
                    if (produto.getEstoque() == 0) {
                        System.out.println("Impossível comprar!\nProduto sem estoque!");
                        Thread.sleep(1000);
                        continue;
                    }

                    System.out.printf("\nItem selecionado: %s\nDigite a quantidade que deseja comprar (Digite 0 para cancelar a compra): ", produto.getNomeItem());
                    opc = sc.nextInt();

                    if (opc <= 0) {
                        System.out.println("\nCancelando compra!");
                        Thread.sleep(1000);
                        continue;
                    } else if (opc > produto.getEstoque()) {
                        System.out.println("\nImpossível efetuar a compra!\nQuantidade de compra superior à quantida dísponivel!");
                        Thread.sleep(1000);
                        continue;
                    } else {
                        pedido.adicionarItem(produto, opc);
                        produto.setEstoque(produto.getEstoque() - opc);
                    }
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    System.out.println("\nO valor digitado deve ser um número!");
                    Thread.sleep(1000);
                } catch (IndexOutOfBoundsException e) {
                    sc.nextLine();
                    System.out.println("\nNúmero do Produto escolhi inválido! Verifique novamente\n");
                    Thread.sleep(1000);

                } catch (Exception e) {
                    System.out.println("\nOcorreu um erro Inesperado!\n");
                    sc.close();
                    return;
                }
            } while(true);

            sc.close();
            pedido.fecharpedido();
    }
}