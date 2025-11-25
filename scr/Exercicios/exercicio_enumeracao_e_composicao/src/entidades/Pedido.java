package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enumeracao.StatusPedido;

public class Pedido {

	private Date momento;
	private StatusPedido status;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Cliente cliente;
	
	private List<PedidoItem> itens = new ArrayList<PedidoItem>();
	
	public Pedido() {
		
	}

	public Pedido(Date momento, StatusPedido status, Cliente cliente) {
		super();
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarProduto(PedidoItem item) {
		itens.add(item);
	}
	
	public void removerProduto(PedidoItem item) {
		itens.remove(item);
	}
	
	public double valorTotal() {
		double soma = 0.0;
		for (PedidoItem it : itens ) {
			soma += it.subTotal();
		}
		return soma;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Data da solicitação: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Status do pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Produtos no pedido:\n");
		for (PedidoItem item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Valor Total: R$");
		sb.append(String.format("%.2f", valorTotal()));
		return sb.toString();
	}
	
}
