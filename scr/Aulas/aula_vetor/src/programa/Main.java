package programa;

import java.util.Locale;
import java.util.Scanner;
import utilidade.Produto;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a quantidade de produtos a serem cadastrados:");
		int numeroProdutos = sc.nextInt();
		Produto[] listaProduto = new Produto[numeroProdutos];		
		
		for(int i=0; i < listaProduto.length; i++) {
			sc.nextLine();
			System.out.println("Digite o nome do produto:" );
			String nome = sc.nextLine();
			System.out.println("Digite o preço do produto:");
			double preco = sc.nextDouble();
			listaProduto[i] = new Produto(nome, preco);
		}
		
		double somaPreco = 0;
		for(int i=0; i < listaProduto.length; i++) {
			somaPreco += listaProduto[i].getPreco();
		}
		
		double mediaPreco = somaPreco / listaProduto.length;
		
		System.out.printf("Preço médio = R$%.2f%n.", mediaPreco);
		
		sc.close();
	}

}
