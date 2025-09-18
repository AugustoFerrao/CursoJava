package entidades;

public class ContaEmpresa extends Conta {

	private Double limiteEmprestimo;
	
	public ContaEmpresa() {
		super();
	}

	public ContaEmpresa(Integer numero, String dono, Double saldo, Double limiteEmprestimo) {
		super(numero, dono, saldo);
		this.limiteEmprestimo = limiteEmprestimo;
	}

	public Double getLimiteEmprestimo() {
		return limiteEmprestimo;
	}

	public void setLimiteEmprestimo(Double limiteEmprestimo) {
		this.limiteEmprestimo = limiteEmprestimo;
	}
	
	public void emprestimo(double quantidade) {
		if(quantidade <= limiteEmprestimo) {
			saldo += quantidade - 10.0;
		}
	}
	
	@Override
	public void saque(double quantidade) {
		super.saque(quantidade);
		saldo -= 2.0;
	}
	
}
