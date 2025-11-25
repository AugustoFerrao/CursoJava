package conta;

public class Cliente {
	

	private int numeroConta;
	private String nome;
	private double saldo;
	
	//construtores
	public Cliente(String nome, int numeroConta) {
		this.nome = nome;
		this.numeroConta = numeroConta;
	}
	
	public Cliente(String nome, int numeroConta, double quantiaInicial) {
		this.nome = nome;
		this.numeroConta = numeroConta;
		deposito(quantiaInicial);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public int getNumeroConta() {
		return numeroConta;
	}
	
	
	public void deposito(double quantia) {
		saldo += quantia;
	}
	public void saque(double quantia) {
		saldo -= quantia + 5.0;
	}
	public double getSaldo() {
		return saldo;
	}

	public String toString() {
		return "Conta: " + numeroConta + ", Títular: " + nome + ", Saldo: R$" + String.format("%.2f",saldo) + ".";
	}
	
}
