package entidades;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Venda {

	private Usuario usuario;
	private List<ItemVenda> itens;
	Date dataVenda;
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	
	// Construtor
	public Venda(Usuario usuario) {
		this.usuario = usuario;
		this.itens = new ArrayList<>();
		this.dataVenda = new Date();
	}
	
	// Método para adicionar um produto a venda
	public void adicionarItem(Produto produto, int quantidade) {
		if(produto.reduzirEstoque(quantidade)) {
			itens.add(new ItemVenda(produto, quantidade));
		}
		else {
			System.out.println("Estoque insuficiente para o produto: " + produto.getNome());
		}
	}
	
	// Método para mostrar o total de uma venda
	public double getTotal() {
		double total = 0;
		for(ItemVenda item : itens) {
			total += item.getSubTotal();
		}
		return total;
	}
	
	// Método que exibe um resumo de uma venda
    public void exibirResumo() throws IOException {
        System.out.println("\nResumo da Venda:");
        System.out.println("Cliente: " + usuario.getNome());
        String dataHoraFormatada = formatador.format(dataVenda);
        System.out.println("Data: " + dataHoraFormatada);
        for (ItemVenda item : itens) {
            System.out.println(item);
        }
        System.out.println("Total: R$" + getTotal());
    }
    
    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubTotal();
        }
        return total;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Compra realizada por: ").append(usuario.getNome()).append("\n");
        sb.append("CPF: ").append(usuario.getCpf()).append("\n");
        sb.append("Itens comprados:\n");
        
        for (ItemVenda item : itens) {
            sb.append(item.toString()).append("\n");
        }

        sb.append("Total: R$").append(calcularTotal()).append("\n");
        sb.append("====================================\n");
        return sb.toString();
    }
    
    //Getters
    public Usuario getUsuario() {
        return this.usuario;
    }
    public List<ItemVenda> getItens() {
        return this.itens;
    }
	public String getDataVenda() {
		return formatador.format(this.dataVenda);
	}
}