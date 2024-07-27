package co.dejailton.bancoitau.bank;

import co.dejailton.bancoitau.log.Log;

public class Conta {
    private static final int MAX_LENGTH = 12;
    private String agencia;
    private String conta;
    private String titular;
    private double balance = 0;
    private Log logger;


    public Conta (String agencia, String conta, String titular) {
        this.agencia = agencia;
        this.conta = conta;
        setTitular(titular);
        logger = new Log();
    }
    public void setTitular(String titular) {
        if (titular.length() > MAX_LENGTH) {
            this.titular = titular.substring(0, MAX_LENGTH);
        } else {
            this.titular = titular;
        }
    }
    public String getAgencia() {
        return agencia;
    }
    public String getConta() {
        return conta;
    }
    public String getTitular() {
        return titular;
    }

    public double getBalance() {
        return balance;
    }
    public void depositar(double value) {
        if (value > 0) {
            balance += value;
            logger.out("DEPOSITO - Foi depositado R$: " + value + ", seu saldo atual R$: " + balance );
        } else {
            logger.out("DEPOSITO - Valor para tentativa de depósito é invalído!");
        }
    }
    public void sacar(double value) {
        if (balance < value && value > 0) {
            logger.out("SAQUE - Saldo insuficiente! Saldo atual R$: " + balance);
        } else if(value > 0) {
            balance -= value;
            logger.out("SAQUE - Foi sacado R$: " + value);
            logger.out("SAQUE - Seu saldo total R$: " + balance);
        } else {
            logger.out("SAQUE: Valor solicitado invalido!");
        }
    }
    public String toString() {
        return "Titular: " + this.titular + "\n" +
                "Agencia: " + this.agencia + "\n" +
                "Conta: " + this.conta + "\n" +
                "Saldo atual R$:" + balance + "\n";
    }
}
