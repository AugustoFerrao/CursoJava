package programa;

import java.util.Locale;
import java.util.Scanner;

import conta.Cliente;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Cliente conta;
		
		System.out.println("Digite os dados abaixo para efetuar a abertura da conta");
		System.out.print("Número da conta:");
		int numero = sc.nextInt();
		System.out.print("Nome do Títular:");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Houve deposito inicial?");
		char resposta = sc.next().charAt(0);
		
		if(resposta == 's') {
			System.out.print("Valor do deposito inicial:");
			double valorInicial = sc.nextDouble();
			conta = new Cliente(titular, numero, valorInicial);
		}
		
		else {
			conta = new Cliente(titular, numero);
		}
		
		System.out.println();
		System.out.println("Dados da conta");
		System.out.println(conta);
		
		System.out.println();
		System.out.print("Digite um quantia para depositar:");
		double depositoValor = sc.nextDouble();
		conta.deposito(depositoValor);
		System.out.println("Dados da conta atualizados:");
		System.out.println(conta);
		
		
		System.out.println();
		System.out.print("Digite um quantia para sacar:");
		double saqueValor = sc.nextDouble();
		conta.saque(saqueValor);
		System.out.println("Dados da conta atualizados:");
		System.out.println(conta);
		
		sc.close();

	}

}
