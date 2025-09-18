package entidades;

public abstract class Contribuinte {

	private String nome;
	private Double ganhoAnual;

	
	public Contribuinte() {
	}

	public Contribuinte(String nome, Double ganhoAnual) {
		super();
		this.nome = nome;
		this.ganhoAnual = ganhoAnual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getGanhoAnual() {
		return ganhoAnual;
	}

	public void setGanhoAnual(Double ganhoAnual) {
		this.ganhoAnual = ganhoAnual;
	}
	
	public abstract double taxa();
}
