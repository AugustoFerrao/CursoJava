package programa;

import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import funcionarios.Funcionarios;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Funcionarios> lista = new ArrayList<>();
		
		//Parte registo
		System.out.println("Quantos empregados serão registrados?");
		int numeroEmpregados = sc.nextInt();		
		
		for(int i=1; i<=numeroEmpregados; i++) {
			System.out.println();
			System.out.println("Empregado #"+ i + ": ");
			
			System.out.println("Id: ");
			int id = sc.nextInt();
			while(temEssaId(lista,id)) {
				System.out.println("ID já utilizado. Cadastre outro ID: ");
				id = sc.nextInt();
			}
			
			System.out.println("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println("Salário: ");
			double salario = sc.nextDouble();
			lista.add(new Funcionarios(id, nome, salario));
		}
		
		//aumento de salario
		System.out.println();
		System.out.println("Digite o ID do funcionário que ira receber o aumento: ");
		int id = sc.nextInt();
		Funcionarios empregado = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if(empregado == null) {
			System.out.println("Funcionário com essa ID não existente!");
		}
		else {
			System.out.println("Digite a porcentagem de aumento salarial:");
			double porcentagem = sc.nextDouble();
			empregado.aumentarSalario(porcentagem);
		}
		
		//lista de empregados
		System.out.println();
		System.out.println("Lista de funcionários:");
		for(Funcionarios obj : lista) {
			System.out.println(obj);
		}
		
		
		sc.close();
	}

	//metodo de comparação de id
	static boolean temEssaId(List<Funcionarios> lista, int id) {
		Funcionarios tem = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return tem != null;
	}

	
}
