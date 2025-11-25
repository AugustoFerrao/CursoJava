package funcionarios;

public class Funcionarios {

	private int id;
	private String nome;
	private Double salario;
	
	public Funcionarios(int id, String nome, Double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return nome;
	}
	public void setName(String nome) {
		this.nome = nome;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public void aumentarSalario(Double porcentagem) {
		salario += salario * porcentagem / 100.0;
	}
	
	public String toString() {
		return  id + ", " + nome + ", R$ " + String.format("%.2f", salario) + ".";
	}
	
}
