package entidade;

public class Funcionario {

	private String nome;
	private Integer horas;
	private Double valorDaHora;
	
	public Funcionario(){
		
	}
	
	public Funcionario(String nome, Integer horas, Double valorDaHora) {
		this.nome = nome;
		this.horas = horas;
		this.valorDaHora = valorDaHora;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getHoras() {
		return horas;
	}


	public void setHoras(Integer horas) {
		this.horas = horas;
	}


	public Double getValorDaHora() {
		return valorDaHora;
	}


	public void setValorDaHora(Double valorDaHora) {
		this.valorDaHora = valorDaHora;
	}
	
	public double pagamento() {
		return horas * valorDaHora;
	}
}
