package entidades;

import excecoes.TransacoesExcecoes;

public class Conta {

	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;
	
	public Conta() {
	}

	public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer Numero) {
		this.numero = Numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String Numero) {
		this.titular = Numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	public void deposit(double amount) {
		saldo += amount;
	}
	
	public void withdraw(double quantidade) {
		validarSaque(quantidade);
		saldo -= quantidade;
	}
	
	private void validarSaque(double quantidade) {
		if (quantidade > getLimiteSaque()) {
			throw new TransacoesExcecoes("Erro de saque: A quantia excede o limite de saque");
		} 
		if (quantidade > getSaldo()) {
			throw new TransacoesExcecoes("Erro de saque: Saldo insuficiente");
		}
	}
}