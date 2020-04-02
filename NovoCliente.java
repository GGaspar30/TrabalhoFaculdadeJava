package avaliacao1;

import java.util.Scanner;

public class NovoCliente {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Informe seu nome: ");
        String nome = sc.nextLine();

        Cliente c01 = new Cliente(nome);

        c01.exibirDados();
        c01.depositar();
        c01.exibirDados();
        c01.sacar();
        c01.exibirDados();
        System.out.println("----------");

        System.out.print("Informe seu nome: ");
        nome = sc.nextLine();

        Cliente c02 = new Cliente(nome);

        c02.exibirDados();
        c02.depositar();
        c02.exibirDados();
        c02.sacar();
        c02.exibirDados();
        System.out.println("----------");
    }

}
