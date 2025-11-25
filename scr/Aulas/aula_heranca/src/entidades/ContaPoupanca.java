package entidades;

public class ContaPoupanca extends Conta{

	private Double taxaJuros;
	
	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(Integer numero, String dono, Double saldo, Double taxaJuros) {
		super(numero, dono, saldo);
		this.taxaJuros = taxaJuros;
	}

	public Double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(Double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
	public void atualizarSaldo() {
		saldo += saldo * taxaJuros;
	}
	
	@Override
	public void saque(double quantidade) {
		saldo -= quantidade;
	}
	
}
