package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contribuinte;
import entidades.Pessoa_Fisica;
import entidades.Pessoa_Juridica;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> list = new ArrayList<Contribuinte>();

		System.out.println("Digite o número de contribuintes: ");
		int n =sc.nextInt();
		
		for (int i = 1; i<=n; i++) {
			System.out.println("Informações do " + i + "° contribuinte:");
			System.out.print("Pessoa Física ou Jurídica (f/j)? ");
			char tipo = sc.next().charAt(0);
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Ganho anual: ");
			double ganhoAnual = sc.nextDouble();
			if(tipo == 'f') {
				System.out.print("Despesas Médicas: ");
				double gastoSaude =sc.nextDouble();
				list.add(new Pessoa_Fisica(nome, ganhoAnual, gastoSaude));
			}
			else {
				System.out.print("Números de empregados: ");
				Integer numedoDeEmpregados = sc.nextInt();
				list.add(new Pessoa_Juridica(nome, ganhoAnual, numedoDeEmpregados));
			}
		}
		System.out.println();
		System.out.println("Valor das Taxas:");
		for(Contribuinte tp : list) {
			System.out.println(tp.getNome() + ": R$ " + String.format("%.2f", tp.taxa()));
		}
		
		System.out.println();
		double soma = 0;
		for(Contribuinte tp : list) {
			soma += tp.taxa();
		}
		System.out.println("Valor Total das Taxas: R$ " + String.format("%.2f", soma));
		
		sc.close();
	}
}
