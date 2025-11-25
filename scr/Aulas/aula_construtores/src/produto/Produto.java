package produto;

public class Produto {
	
	private String nome;
	private double preco;
	private int estoque;
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public Produto(String nome, double preco, int estoque) {
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double totalValorNoEstoque() {
		return preco * estoque;
	}
	
	public void adicionarProduto(int quantidade) {
		estoque += quantidade;
	}
	
	public void retirarProduto(int quantidade) {
		estoque -= quantidade;
	}
	
	public String toString() {
		return nome + ", R$ " + String.format("%.2f", preco) + ", " + estoque + " em estoque. Valendo R$ " + String.format("%.2f", totalValorNoEstoque());
	}

}
