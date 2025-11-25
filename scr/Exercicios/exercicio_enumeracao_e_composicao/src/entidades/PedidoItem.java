package entidades;

public class PedidoItem {

	private Integer quantidade;
	private Double preco;
	
	private Produto produto;
	
	public PedidoItem(Integer quantidade, Double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreço() {
		return preco;
	}

	public void setPreço(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public double subTotal() {
		return preco * quantidade;
	}
	
	@Override
	public String toString() {
		return getProduto().getNome() 
				+ ", R$"
				+ String.format("%.2f", preco)
				+ ", Quantidade: "
				+ quantidade
				+ ", Subtotal: R$"
				+ String.format("%.2f", subTotal());
	}
}
