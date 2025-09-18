package exercicio_matriz;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o valor do número de linhas da matrix:");
		int linha = sc.nextInt();
		System.out.println("Digite o valor do número de colunas da matrix:");
		int coluna = sc.nextInt();
		
		int[][] matrix = new int[linha][coluna];
		
		System.out.println("Digite os valores dos número que compoem a matrix:");
		
		for(int l=0; l<matrix.length; l++) {
			for(int c=0;c<matrix[l].length;c++) {
				System.out.println("Digite o valor do número na posição : "+ (l+1) + "," + (c+1) +".");
				matrix[l][c] = sc.nextInt();
			}
		}
		
		System.out.println("Digite um número para procurar na matrix:");
		int numeroProcura = sc.nextInt();
		
		for(int l=0; l<matrix.length; l++) {
			for(int c=0;c<matrix[l].length;c++) {
				if(matrix[l][c] == numeroProcura) {
					System.out.println("A posição do número encontrado é: " + l +","+ c +".");
					if(c>0) {
						System.out.println("Número a esquerda: " + matrix[l][c-1] +".");
					}
					if(l>0) {
						System.out.println("Número a acima: " + matrix[l-1][c] +".");
					}
					if(c<matrix[l].length-1) {
						System.out.println("Número a direita: " + matrix[l][c+1] +".");
					}
					if(l<matrix.length-1) {
						System.out.println("Número a abaixo: " + matrix[l+1][c] +".");
					}
					
				}
			}
		}
		
		
		sc.close();

	}

}
