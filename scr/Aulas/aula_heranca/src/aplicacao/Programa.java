package aplicacao;

import entidades.Conta;
import entidades.ContaEmpresa;
import entidades.ContaPoupanca;

public class Programa {

	public static void main(String[] args) {
		
		Conta acc = new Conta(1001, "Guto", 1000.0);
		ContaEmpresa eacc = new ContaEmpresa(1002, "Cláudio", 0.0, 500.0);
		
		//Upcasting
		
		Conta acc1 = eacc;
		System.out.println(acc1.getDono());
		Conta acc2 = new ContaEmpresa(1003, "Vitor", 1000.0 ,500.0);
		Conta acc3 = new ContaPoupanca(1004, "Ana", 1000.0, 0.01);
		
		//Downcasting
		
		ContaEmpresa acc4 = (ContaEmpresa)acc2;
		acc4.emprestimo(100.0);
		
		// ContaEmpresa acc5 = (ContaEmpresa)acc3;
		
		if(acc3 instanceof ContaEmpresa) {
			ContaEmpresa acc5 = (ContaEmpresa)acc3;
			acc5.emprestimo(200.0);
			System.out.println("Emprestimo!");
		}
		
		if(acc3 instanceof ContaPoupanca) {
			ContaPoupanca acc5 = (ContaPoupanca)acc3;
			System.out.println(acc5.getDono());
			System.out.println("Atualizou");
		}
		
		acc.saque(200.0);
		System.out.println(acc.getSaldo());
		
		acc2.saque(200.0);
		System.out.println(acc2.getSaldo());
		
		acc3.saque(200.0);
		System.out.println(acc3.getSaldo());
	}
}
