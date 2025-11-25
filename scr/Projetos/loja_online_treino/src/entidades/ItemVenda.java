package entidades;

public class ItemVenda {

	private Produto produto;
	private int quantidade;
	
	// Construtor
	public ItemVenda(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	//Método para mostrar o preço total de um produto
	public double getSubTotal() {
		return produto.getPreco() * quantidade;
	}
	
	@Override
	public String toString() {
		return produto.getNome() + " x" + quantidade + " =R$" + getSubTotal();
	}
}