package entidades;

public class Funcionario {
	
	public String nome;
	public double salarioBruto;
	public double imposto;
	
	public double SalarioReal() {
		double salarioReal = salarioBruto - imposto;
		return salarioReal;
	}
	
	public void AumentarSalario(double percentagem) {
		salarioBruto += salarioBruto * percentagem / 100;
	}

	public String toString() {
		return nome + ", R$ " + String.format("%.2f", SalarioReal()) + ".";
	}
}
