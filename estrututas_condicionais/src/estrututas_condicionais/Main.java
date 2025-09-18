package estrututas_condicionais;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o seu salário:");
		double salario = sc.nextDouble();
		double imposto;
		
		//Condicionamento - if else
		
		if (salario <= 2000.0) {
			imposto = 0.0;
		}
		else if (salario <= 3000.0) {
			imposto = (salario - 2000.0) * 0.08;
		}
		else if (salario <= 4500.0) {
			imposto = (salario - 3000.0) * 0.18 + 1000.0 * 0.08;
		}
		else {
			imposto = (salario - 4500.0) * 0.28 + 1500.0 * 0.18 + 1000.0 * 0.08;
		}

		if (imposto == 0.0) {
			System.out.println("Isento");
		}
		else {
			System.out.printf("Total a ser pago de imposto R$ %.2f%n%n%n", imposto);
		}
		
		System.out.println("Digite o valor do preço:");
		double preco = sc.nextDouble();
		//Condicionamento - Expressão de condicional térnaria
		double desconto = (preco < 20.0) ? preco * 0.1 : preco * 0.05;
		
		System.out.printf("Seu desconto é de: R$ %.2f Reais", desconto);
		
		sc.close();
	}

}
