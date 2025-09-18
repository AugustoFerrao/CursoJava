package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Produto> list = new ArrayList<>();
		
		System.out.print("Digite o número de produtos: ");
		int numero = sc.nextInt();
		
		for (int i=1; i<=numero; i++) {
			System.out.println("Digite os dados do produto #" + i +":");
			System.out.println("Qual tipo do produto:");
			System.out.print("Comum, Importado, Usado (c/i/u)? ");
			char tipoProduto = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			
			if (tipoProduto == 'c') {
				list.add(new Produto(nome, preco));
			}

			else if(tipoProduto == 'i') {
				System.out.print("Taxa de Importação: ");
				double custoAlfandega = sc.nextDouble();
				list.add(new ProdutoImportado(nome, preco, custoAlfandega));
			}

			else {
				System.out.print("Data de Fabricação: ");
				LocalDate data = LocalDate.parse(sc.next(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new ProdutoUsado(nome, preco, data));
			}	
		}
		
		System.out.println();
		System.out.println("Etiqueta de Preço:");
		for(Produto produto : list) {
			System.out.println(produto.etiquetaPreco());
		}
		sc.close();
	}
}
