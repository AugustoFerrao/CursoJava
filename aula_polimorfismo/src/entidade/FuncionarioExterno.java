package entidade;

public class FuncionarioExterno extends Funcionario{
	
	private Double valorAdicional;
	
	public FuncionarioExterno() {
		super();
	}

	public FuncionarioExterno(String nome, Integer horas, Double valorDaHora, Double valorAdicional) {
		super(nome, horas, valorDaHora);
		this.valorAdicional = valorAdicional;
	}

	public Double getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(Double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}
	
	@Override
	public double pagamento() {
		return super.pagamento() + valorAdicional * 1.1;
	}
}
