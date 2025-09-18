package entidades;

public class ContaEmpresa extends Conta{

	private Double limiteEmprestimo;
	
	public ContaEmpresa() {
	}

	public ContaEmpresa(Integer numeroConta, String titular, Double saldo, Double limiteEmprestimo) {
		super(numeroConta, titular, saldo);
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
			saldo += quantidade -10;
		}
	}
	
	@Override
	public void saque(double quantidade) {
		super.saque(quantidade);
		saldo -= 2.0;
	}
}
