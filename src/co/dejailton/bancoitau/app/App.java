package co.dejailton.bancoitau.app;

import co.dejailton.bancoitau.bank.Bank;
import co.dejailton.bancoitau.bank.Conta;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank itau = new Bank("0001");
        while (true) {
            System.out.println("Digite a opção desejada:" + "\n" +
                    "C = Criar conta" + "\n" +
                    "E = Sair do programa");
            String op = input.next().toUpperCase();

            if (op.equals("C")) {
                System.out.println("Digite o seu nome:");
                String nome = input.next();
                Conta conta = itau.geradorContas(nome);
                itau.inserirConta(conta);
                operateAccount(conta);
            } else if (op.equals("E")) {
                System.out.println("Programa encerrado!");
                break;
            } else {
                System.out.println("Opção invalída! Tente novamente.");
            }
        }
        List<Conta> contaList = itau.getConta();
        for( Conta cc : contaList) {
            System.out.println(cc);
        }
        itau.getSaldoBanco();
    }

    static void operateAccount(Conta conta) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Digite a opção desejada: " + "\n" +
                    "D = Depósito" + "\n" +
                    "S = Saque" + "\n" +
                    "E = Sair da conta (EXIT)");
            String op = input.next().toUpperCase();
            if (op.equals("D")) {
                System.out.println("Digite quanto deseja depositar:");
                conta.depositar(input.nextInt());
            } else if (op.equals("S")) {
                System.out.println("Digite quanto deseja sacar:");
                conta.sacar(input.nextInt());
            } else if (op.equals("E")) {
                System.out.println("Saiu da conta!");
                break;
            } else {
                System.out.println("Opção invalída! Tente novamente.");
            }

        }
    }
}

