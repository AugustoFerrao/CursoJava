package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Pedido;
import entidades.PedidoItem;
import entidades.Produto;
import entidades.enumeracao.StatusPedido;

public class Programa {

	public static void main(String args[]) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Digite os dados do cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Data de nascimento (DD/MM/YYYY): ");
		Date dataNascimento = sdf.parse(sc.next());
		
		Cliente cliente = new Cliente(nome, email, dataNascimento);
		
		System.out.println("Digite os dados do pedido");
		System.out.println("Status: ");
		StatusPedido status = StatusPedido.valueOf(sc.next());
		
		Pedido pedido = new Pedido(new Date(), status, cliente);
		
		System.out.println("Quantos produtos tem nesse pedido? ");
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			System.out.println("Digite os dados do " + (i+1)+ "º produto:");
			System.out.println("Nome do produto: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.println("Preço do produto");
			double precoProduto = sc.nextDouble();
			System.out.println("Quantidade: ");
			int quantidade = sc.nextInt();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			
			PedidoItem pi = new PedidoItem(quantidade, precoProduto, produto);
			
			pedido.adicionarProduto(pi);
			
		}
		System.out.println();
		System.out.println(pedido);
		
		sc.close();
	}
}
