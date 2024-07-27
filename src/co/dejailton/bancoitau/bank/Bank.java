package co.dejailton.bancoitau.bank;

import co.dejailton.bancoitau.log.Log;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String agencia;
    private List<Conta> contas;
    private int lastAccount = 1;
    private Log logger;

    public Bank(String agencia) {
        this.agencia = agencia;
        this.contas = new ArrayList<>();
        logger = new Log();
    }

    public List<Conta> getConta() {
        return contas;
    }
    public void getSaldoBanco() {
        double saldoTotal = 0;
        for(Conta conta : contas) {
            double balance = conta.getBalance();
            saldoTotal += balance;
        }
        logger.out("Saldo do banco itaú R$: " + saldoTotal);
    }

    public void inserirConta(Conta conta) {
        contas.add(conta);
    }
    public Conta geradorContas(String nome) {
        Conta contas = new Conta(agencia, "" + lastAccount, nome);
        lastAccount++;
        return contas;
    }
}
