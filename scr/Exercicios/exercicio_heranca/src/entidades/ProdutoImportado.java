package entidades;

public class ProdutoImportado extends Produto{
	
	private double custoAlfandega;

	public ProdutoImportado(String nome, Double preco, double custoAlfandega) {
		super(nome, preco);
		this.custoAlfandega = custoAlfandega;
	}
	
	public double getCustoAlfandega() {
		return custoAlfandega;
	}

	public void setCustoAlfandega(double custoAlfandega) {
		this.custoAlfandega = custoAlfandega;
	}
	
	public Double precoTotal() {
		return getPreco() + custoAlfandega;
	}

	@Override
	public String etiquetaPreco() {
		return getNome() 
				+ " R$ " 
				+ String.format("%.2f",precoTotal()) 
				+ " (Taxa da Alfandega: R$ " 
				+ String.format("%.2f", custoAlfandega) 
				+ ")";
	}
}
