package programa;

import java.util.Locale;
import java.util.Scanner;

import conversor.Conversor;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a cotação do dolar:");
		double cotacaoDolar = sc.nextDouble();
		System.out.println("Digite quantos dolars quer comprar:");
		double quantosDolars = sc.nextDouble();
		
		double quantoPagar = Conversor.dolarParaReal(cotacaoDolar, quantosDolars);	
		System.out.printf("Quanto vc pagara em reais: %.2f.%n", quantoPagar);
	
		sc.close();

	}

}
