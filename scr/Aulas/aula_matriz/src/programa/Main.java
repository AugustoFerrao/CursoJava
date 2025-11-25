package programa;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o tamanho da matriz quadrada:");
		int n = sc.nextInt();
		int[][] matriz = new int[n][n];
		
		for(int L=0; L<matriz.length; L++) {
			for(int C=0; C<matriz[L].length;C++) {
				matriz[L][C]=sc.nextInt();
			}
		}
		System.out.print("Números da diagonal principal: ");
		
		for(int i=0; i<matriz.length; i++) {
			System.out.print(matriz[i][i] + " ");
		}
		System.out.println();
		
		int numerosNegativos = 0;
		
		for(int L=0; L<matriz.length; L++) {
			for(int C=0; C<matriz[L].length;C++) {
				if(matriz[L][C] < 0) {
					numerosNegativos++;
				}
			}
		}
		
		System.out.println("Quantidade de números negativos: " + numerosNegativos);
		
		sc.close();
	}

}
