package estrutura_do_while;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		char resposta;
		//ler uma vez e repete se a condição for verdadeira
		do {
			System.out.print("Digite a temperatura em Celsius: ");
			double celsio = sc.nextDouble();
			double fahren = 9.0 * celsio / 5.0 + 32.0;
			System.out.printf("Equivalente em Fahrenheit: %.1f%n", fahren);
			System.out.print("Deseja repetir (s/n)? ");
			resposta = sc.next().charAt(0);		
		} while(resposta != 'n');
		
		sc.close();
	}

}
