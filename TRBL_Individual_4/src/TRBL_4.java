import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TRBL_4 {
    public static void main(String[] args) throws InterruptedException {

        // ----- ----- LISTAS QUE VAO CONTER OS VEICULOS DISPONIVEIS ----- -----

        List<Caminhao> caminhoes = new ArrayList<>();
        List<CarroPasseio> carros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // ----- ----- ADICIONANDO VALORES DE EXEMPLO ----- -----

        try {
            carros.add(new CarroPasseio("Corolla", "ABC-1234", "Toyota", 150.0, 2022, 95000.0));
            carros.add(new CarroPasseio("Civic", "XYZ-9876", "Honda", 180.0, 2021, 110000.0));
            carros.add(new CarroPasseio("Gol", "DEF-5555", "Volkswagen", 120.0, 2015, 45000.0));

            caminhoes.add(new Caminhao("FH 540", "KJG-1111", "Volvo", 850.0, 2020, 450000.0, 15.0));
            caminhoes.add(new Caminhao("Actros", "LMN-2222", "Mercedes-Benz", 980.0, 2022, 520000.0, 20.0));
            caminhoes.add(new Caminhao("R 450", "OPQ-3333", "Scania", 1200.0, 2023, 700000.0, 25.0));

        } catch (InputMismatchException e) {
            System.out.println("\nTipo de caractere inserido inválido! Verifique o tipo e tente novamente");
            return;

        } catch (Exception e) {
            System.out.println("\nErro Inesperado!");
            return;
        }
        // ----- ----- EXECUÇÃO DA ESCOLHA ----- -----

        Integer opc = 0;

        do{
            try {
                Integer catalogo = 1;

                for (int i = 0; i < carros.size(); i++) {
                    CarroPasseio carro = carros.get(i);

                    System.out.printf("\n\nVeiculo: %d\n%s\nMarca: %s     Ano: %d\nDiária: R$ %.2f",
                            catalogo, carro.getModelo(), carro.getMarca(), carro.getAnoFabricacao(),
                            carro.getValorLocacaoDiaria());

                    catalogo++;
                }

                for (int i = 0; i < caminhoes.size(); i++) {
                    Caminhao caminhao = caminhoes.get(i);

                    System.out.printf("\n\nVeiculo: %d\n%s\nMarca: %s     Ano: %d\nPeso de Carga do Veiculo: %.2f Toneladas\nDiária: R$ %.2f",
                            catalogo, caminhao.getModelo(), caminhao.getMarca(), caminhao.getAnoFabricacao(),
                            caminhao.getCapacidadeCargaToneladas(),caminhao.getValorLocacaoDiaria());

                    catalogo++;
                }

                System.out.print("\n\nSelecione qual Veiculo deseja Alugar! (Digite 0 para encerrar o programa): ");
                opc = sc.nextInt();


                // ----- ----- VERIFICAÇÃO DE INDICE INVÁLIDO OU CONDIÇÃO DE ENCERRAMENTO DO CÓDIGO ----- -----

                if (opc <= 0) {
                    System.out.println("\n\nEncerrando programa!");
                    break;  // sair do while
                } else if (opc > catalogo-1){
                    throw new IndexOutOfBoundsException();
                }

                // ----- ----- EXECUÇÃO DA COMPRA ----- -----

                System.out.print("Digite a quantidade de dias que deseja alugar: ");
                Integer dias = sc.nextInt();

                if (opc > carros.size()){
                    Caminhao caminhaoAlugado = caminhoes.get(opc-1-carros.size());

                    System.out.print("Digite o peso da carga que deseja carregar (em Toneladas): ");
                    Double carga = sc.nextDouble();

                    System.out.println("\n\n\nAluguel confirmado! Carregando nota fiscal!");

                    System.out.println("----- NOTA FISCAL -----");
                    System.out.printf("Veiculo: %s\nMarca: %s     Ano: %d     Placa: %s\nValor final do aluguel: %.2f\nIPVA: %.2f",
                            caminhaoAlugado.getModelo(), caminhaoAlugado.getMarca(), caminhaoAlugado.getAnoFabricacao(),
                            caminhaoAlugado.getPlaca(), caminhaoAlugado.AlugarVeiculo(carga, dias), caminhaoAlugado.CalcularIPVA());

                    break;

                } else{
                    CarroPasseio CarroAlugado = carros.get(opc-1);

                    System.out.println("\n\n\nAluguel confirmado! Carregando nota fiscal!");

                    System.out.println("----- NOTA FISCAL -----");
                    System.out.printf("Veiculo: %s\nMarca: %s     Ano: %d     Placa: %s\nValor final do aluguel: %.2f\nIPVA: %.2f",
                            CarroAlugado.getModelo(), CarroAlugado.getMarca(), CarroAlugado.getAnoFabricacao(),
                            CarroAlugado.getPlaca(), CarroAlugado.AlugarVeiculo(0.00 , dias), CarroAlugado.CalcularIPVA());
                    break;
                }

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("\nO valor digitado deve ser um número e devem ser usado virgula para decimais!");
                Thread.sleep(1000);
            } catch (IndexOutOfBoundsException e) {
                sc.nextLine();
                System.out.println("\nNúmero do Veiculo escolhido inválido! Verifique novamente\n");
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("\nOcorreu um erro Inesperado!\n");
                sc.close();
                return;
            }
        } while(true);
        sc.close();
    }
}
