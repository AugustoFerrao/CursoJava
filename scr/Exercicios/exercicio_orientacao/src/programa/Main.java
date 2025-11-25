package programa;

import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Funcionario funcionario = new Funcionario();
		
		System.out.println("Digite os dados do funcionário");
		System.out.println("Nome:");
		funcionario.nome = sc.nextLine();
		System.out.println("Salário Bruto:");
		funcionario.salarioBruto = sc.nextDouble();
		System.out.println("Imposto:");
		funcionario.imposto = sc.nextDouble();
		
		System.out.println(funcionario);
		System.out.println("");
		
		System.out.println("Digite a porcentagem do aumento salarial:");
		double porcentagem;
		porcentagem = sc.nextDouble();
		funcionario.AumentarSalario(porcentagem);
		
		System.out.println("Dados atualizados do Funcionário - " + funcionario);
		
		sc.close();

	}

}
