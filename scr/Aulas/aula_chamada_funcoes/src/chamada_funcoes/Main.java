package chamada_funcoes;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("Digite 3 números para saber o maior deles:");
		Scanner sc = new Scanner(System.in);
		System.out.println("Número 1:");
		int numero1 = sc.nextInt();
		System.out.println("Número 2:");
		int numero2 = sc.nextInt();
		System.out.println("Número 3:");
		int numero3 = sc.nextInt();
		
		int maiorNumero = maior(numero1, numero2, numero3);
		mostraResultado(maiorNumero);
		
		sc.close();
	}
	
	public static int maior(int x, int y, int z) {

		int valor;
		if(x > y && x > z) {
			valor = x;
		}
		else if(y > z) {
			valor = y;
		}
		else {
			valor = z;
		}
		return valor;
	}
	
	public static void mostraResultado(int valor) {
		System.out.println("O maior dos numeros digitados é: " + valor + "." );
	}
}
