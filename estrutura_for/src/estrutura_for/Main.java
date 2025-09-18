package estrutura_for;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Digite uma quantidade de numeros a ser somados:");
		int quantidade = sc.nextInt();
		
		int total = 0;
		
		//      inicio      -  condição de repetição  -  incremento
		for (int repeticao=1; (repeticao-1)<quantidade; repeticao++) {
			System.out.println("Digite o "+ repeticao +"° número:");
			int numero = sc.nextInt();
			total = total + numero;
		}
		
		System.out.println("O total da soma deu: "+ total);
		sc.close();
	}
}
