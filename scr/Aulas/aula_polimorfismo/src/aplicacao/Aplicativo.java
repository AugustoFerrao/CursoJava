package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Funcionario;
import entidade.FuncionarioExterno;

public class Aplicativo {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> list = new ArrayList<>();
		
		System.out.print("Digite o número de funcionários: ");
		int numero = sc.nextInt();
		
		for (int i=1; i<=numero; i++) {
			System.out.println("Digite informações do funcionário número " + i + ": ");
			System.out.print("Funcionário Externo (s/n)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Horas trabalhadas: ");
			int horas = sc.nextInt();
			System.out.print("Valor da hora: ");
			double valorPorHora = sc.nextDouble();
			
			if(ch == 's') {
				System.out.print("Valor adicional: ");
				double valorAdicional = sc.nextDouble();
				list.add(new FuncionarioExterno(nome, horas, valorPorHora, valorAdicional));
			}
			else {
				list.add(new Funcionario(nome, horas, valorPorHora));
			}
		}
		
		System.out.println();
		System.out.println("Pagamentos e valores:");
		for(Funcionario emp : list) {
			System.out.println(emp.getNome() + " - R$ " + String.format("%.2f", emp.pagamento()));
		}
		
		sc.close();
	}

}
