package avaliacao1;

import java.util.Scanner;

public class Cliente {

    private String nome;
    private int numeroConta;
    private float saldo;
    private float limite;
    private static int auxConta = 0;

    Scanner sc = new Scanner(System.in);

    public Cliente(String nome) {
        this.nome = nome;
        this.numeroConta = gerarNumeroConta();
        this.saldo = 0.0f;
        this.limite = 0.0f;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limete) {
        this.limite = limete;
    }

    public void sacar() {
        float saque;
        do {
            System.out.print("Informe o valor a sacar: ");
            saque = sc.nextFloat();
            if (saque != 0) {
                if (saque <= getSaldo()) {
                    setSaldo(getSaldo() - saque);
                    verificarLimite(getSaldo()); // <--- para pegar somente o limite do primeiro valor depositado comentar a chamada da função
                    System.out.println("Saque realizado com sucesso!");
                } else {

                    System.out.println("“Saldo insuficiente!");
                }
            } else {
                System.out.println("Valor zerado!");
            }
        } while (saque <= 0);
    }

    public void depositar() {
        float deposito;
        do {
            System.out.print("Informe o valor a depositar: ");
            deposito = sc.nextFloat();

            if (deposito > 0) {
                setSaldo(deposito);
                verificarLimite(getSaldo());// <--- para pegar somente o limite do  valor com o saque realizado comentar a chamada da função
                System.out.println("“Crédito realizado com sucesso");
            } else {
                System.out.println("Valor negativo!");
            }
        } while (deposito <= 0);
    }

    public void exibirDados() {
        System.out.println("-------DADOS DO CLIENTE-------");
        System.out.println("Nome do cliente: " + getNome());
        System.out.println("Nº da conta: " + getNumeroConta());
        System.out.println("Saldo da conta: " + getSaldo());
        if (getSaldo() > 0) {
            System.out.println("Status da conta: Saldo Positivo!");
        } else {
            System.out.println("Status da conta: Saldo Negativo!");
        }
        System.out.println("Seu limite é de: " + getLimite());
        System.out.println("----------");

    }

    // Função vai sempre pegar o valor atualizado do saldo para calcular o limite do cliente
    private float verificarLimite(float deposito) {

        float limite = deposito;
        if (getLimite() <= 2000) {
            limite = (getSaldo() * 30) / 100;
            setLimite(limite);

        } else if (limite > 2000 && limite <= 5000) {
            limite = (getSaldo() * 50) / 100;
            setLimite(limite);
        } else if (limite > 5000) {
            limite = (getSaldo() * 70) / 100;
            setLimite(limite);

        }

        return limite;

    }

    private static int gerarNumeroConta() {

        return ++auxConta;
    }

}
