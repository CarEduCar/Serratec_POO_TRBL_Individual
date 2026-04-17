package TRBL_Individual1.TRBL_1;
import java.util.Scanner;

public class TRBL_1 {
    public static void main(String[] args) {
        int opc;
        double saldo = 0;
        int saques = 0;
        double auxiliar;

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("\n");
            System.out.print("Digite qual opção você deseja:\n1- Ver Saldo\n2-Depositar\n3-Sacar\n0-Sair\nEntrada: ");
            opc = sc.nextInt();
            System.out.print("\n");

            switch (opc){
                case 0:
                    System.out.println("\nSaindo...");
                    return;
                case 1:
                    System.out.printf("O seu saldo é de: %.2f", saldo);
                    break;

                case 2:
                    System.out.print("Digite o valor que deseja Depositar: ");
                    auxiliar = sc.nextDouble();

                    if(auxiliar <= 0){
                        System.out.print("\nValor inválido para Depósito!");
                    } else{
                        saldo += auxiliar;
                    }
                    break;

                case 3:
                    if(saques == 3){
                        System.out.println("Limite de saques diários antigido!");
                        break;
                    }
                    System.out.print("Digite o valor que deseja Sacar: ");
                    auxiliar = sc.nextDouble();

                    if(saldo<auxiliar){
                        System.out.print("\nSaque Inválido!\nSaldo inferior ao valor de Saque!");
                    } else{
                        saldo -= auxiliar;
                        saques++;
                        System.out.print("\nSaque efetuado com sucesso!");
                    }
                    break;

                default:
                    System.out.print("\nValor inválido!");
                    break;
            }
        } while(true);
    }
}

