package entidades;

public class Pessoa_Juridica extends Contribuinte{
	
	private Integer numeroDeEmpregados;

	public Pessoa_Juridica() {
	}

	public Pessoa_Juridica(String nome, Double ganhoAnual, Integer numeroDeEmpregados) {
		super(nome, ganhoAnual);
		this.numeroDeEmpregados = numeroDeEmpregados;
	}

	public Integer getNumeroDeEmpregados() {
		return numeroDeEmpregados;
	}

	public void setNumeroDeEmpregados(Integer numeroDeEmpregados) {
		this.numeroDeEmpregados = numeroDeEmpregados;
	}

	@Override
	public double taxa() {
		if(numeroDeEmpregados > 10) {
			return getGanhoAnual() * 0.14;
		}
		else {
			return getGanhoAnual() * 0.16;
		}

	}
	
	
}
