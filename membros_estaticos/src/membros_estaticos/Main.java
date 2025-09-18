package membros_estaticos;

import java.util.Locale;
import java.util.Scanner;

import util.Calculadora;

public class Main {

	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o raio:");
		double raio = sc.nextDouble();
		
		double c = Calculadora.circunferencia(raio);
		
		double v = Calculadora.volume(raio);
		
		System.out.printf("Circunferencia: %.2f%n", c);
		System.out.printf("Volume: %.2f%n", v);
		System.out.printf("Valor de PI: %.2f%n", Calculadora.PI);
		
		sc.close();
	}
}
