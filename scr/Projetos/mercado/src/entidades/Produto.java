package entidades;

public class Produto {
	
	public String nome;
	public double preco;
	public int estoque;
	
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
