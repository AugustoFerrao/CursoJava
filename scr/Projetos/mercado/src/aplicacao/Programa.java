package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Produto produto = new Produto();
		
		System.out.println("Informe dados do produto.");
		System.out.println("Digite o nome do produto:");
		produto.nome = sc.nextLine();
		System.out.println("Digite o preço do produto:");
		produto.preco = sc.nextDouble();
		System.out.println("Digite a quantidade do produto no estoque:");
		produto.estoque = sc.nextInt();
		
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
