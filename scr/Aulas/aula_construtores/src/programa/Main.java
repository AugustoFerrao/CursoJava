package programa;

import java.util.Locale;
import java.util.Scanner;

import produto.Produto;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe dados do produto.");
		System.out.println("Digite o nome do produto:");
		String nome = sc.nextLine();
		System.out.println("Digite o preço do produto:");
		double preco = sc.nextDouble();
		//criando um construto onde ele precisa de argumentos evita a criação de um construtor "vazio".
		Produto produto = new Produto(nome, preco);
		
		System.out.println();
		System.out.println("Dados do produto: " + produto);
		
		System.out.println();
		System.out.println("Digite a quantidade de produtos a serem adicionados:");
		int quantidade = sc.nextInt();
		produto.adicionarProduto(quantidade);
		System.out.println("Dados do produto atualizado: " + produto + ".");
		
		System.out.println();
		System.out.println("Digite a quantidade de produtos a serem retirados:");
		quantidade = sc.nextInt();
		produto.retirarProduto(quantidade);
		System.out.println("Dados do produto atualizado: " + produto + ".");
		
		sc.close();
	}

}
