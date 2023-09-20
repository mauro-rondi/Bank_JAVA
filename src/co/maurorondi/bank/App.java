package co.maurorondi.bank;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Bank santander = new Bank("0001");
        Scanner scanner = new Scanner(System.in);

        // Criando conta no banco
        while (true) {
            System.out.println("1 - Criar conta");
            System.out.println("2 - Sair do programa");

            System.out.println("Digite o numero da operação desejada:");
            String op1 = scanner.nextLine();

            if (op1.equals("1")) {
                System.out.println("Digite seu nome:");
                String name = scanner.nextLine();
                Account account = santander.generateAccount(name);
                santander.insertAccount(account);

                operateAccount(account);
            } else if (op1.equals("2")) {
                break;
            } else {
                System.out.println("Número de operação inválido, TENTE NOVAMENTE!");
            }
        }

        List<Account> accountList = santander.getAccounts();
        for(Account cc : accountList){
            System.out.println(cc);
        }
        santander.outputTotal();
    }

    static void operateAccount(Account account){
        // Depositar, Saque, Sair
        Scanner scanner = new Scanner(System.in);

        // REALIZANDO OPERAÇÕES NA SUA CONTA
        while(true){
            System.out.println("1 - DEPÓSITO");
            System.out.println("2 - SAQUE");
            System.out.println("3 - SAIR");

            System.out.println("Digite o número da operação desejada: ");
            String op = scanner.nextLine();

            switch (op) {
                case "1":
                    System.out.println("Qual valor deseja depositar?");
                    double value = scanner.nextDouble();
                    account.deposit(value);
                    break;
                case "2":
                    System.out.println("Qual valor deseja sacar?");
                    value = scanner.nextDouble();
                    if (!account.withDraw(value)){
                        System.out.println("Saldo insufuciente para saque!");
                    }
                case "3":
                    break;
                default:
                    System.out.println("Número de operação inválido, TENTE NOVAMENTE!");
                    break;
            }
            if(op.equals("3")){
                break;
            }
            scanner = new Scanner(System.in); // AO FINAL DO LOOPING ELE CRIA UM NOVO SCANNER PRA EVITAR O BUG MULTIPLOS
        }
    }
}
