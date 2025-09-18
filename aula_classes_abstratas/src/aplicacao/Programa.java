package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entidades.Conta;
import entidades.ContaEmpresa;
import entidades.ContaPoupanca;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Conta> lista = new ArrayList<>();
		
		lista.add(new ContaPoupanca(101, "Guto", 500.0, 0.01));
		lista.add(new ContaEmpresa(102, "Cláudio", 1000.0, 400.0));
		lista.add(new ContaPoupanca(103, "Vitor", 300.0, 0.01));
		lista.add(new ContaEmpresa(105, "Kadu", 500.0, 500.0));

		double soma = 0.0;
		for (Conta acc : lista) {
			soma += acc.getSaldo();
		}
		
		System.out.printf("O saldo total das contas é: %.2f%n",soma);
		
		for(Conta acc : lista) {
			acc.deposito(10.0);
		}
		for(Conta acc : lista ) {
			System.out.printf("Saldo atualizado das contas %d: %.2f%n", acc.getNumeroConta(), acc.getSaldo());
		}
		
	}

}
