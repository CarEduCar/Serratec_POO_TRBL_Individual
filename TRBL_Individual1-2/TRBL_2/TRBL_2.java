package TRBL_Individual1.TRBL_2;

import java.util.Scanner;

public class TRBL_2 {
    public static void main(String[] args) {
        int opc;
        int saques = 0;
        double auxiliar;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome completo para criar a conta:\n");
        ContaBancaria usuario = new ContaBancaria(sc.nextLine());

        do{

            System.out.print("\n\nDigite qual opção você deseja:\n1- Ver Saldo\n2- Depositar\n3- Sacar\n4- Ver Dados da Conta\n0-Sair\nEntrada: ");
            opc = sc.nextInt();
            System.out.print("\n");

            switch (opc){
                case 0:
                    System.out.println("\nSaindo...");
                    return;
                case 1:
                    System.out.printf("Saldo da Conta: %.2f", usuario.GetSaldo());
                    break;

                case 2:
                    System.out.print("Digite o valor que deseja Depositar: ");
                    auxiliar = sc.nextDouble();

                    if(auxiliar <= 0){
                        System.out.print("\nValor inválido para Depósito!");
                    } else{
                        usuario.SetSaldo(auxiliar);
                    }
                    break;

                case 3:
                    if(saques == 3){
                        System.out.println("Limite de saques diários antigido!");
                        break;
                    }
                    System.out.print("Digite o valor que deseja Sacar: ");
                    auxiliar = sc.nextDouble();

                    if(usuario.GetSaldo() < auxiliar){
                        System.out.print("\nSaque Inválido!\nSaldo inferior ao valor de Saque!");
                    } else{
                        usuario.SetSaldo(-auxiliar);
                        saques++;
                        System.out.print("\nSaque efetuado com sucesso!");
                    }
                    break;
                case 4:
                    System.out.printf("UID da conta: %d\nTitular: %s\nSaldo: %.2f", usuario.GetNumero(), usuario.GetNome(), usuario.GetSaldo());
                    break;
                default:
                    System.out.print("\nValor inválido!");
                    break;
            }
        } while(true);
    }
}
