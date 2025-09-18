package aplication;

import java.util.Date;

import entities.Pedido;
import entities.enums.StatusPedido;

public class Program {

	public static void main(String[] args) {
		
		StatusPedido os1 = StatusPedido.Entregue;
		StatusPedido os2 = StatusPedido.valueOf("Entregue");
		
		Pedido pedido = new Pedido(1080, new Date(), os1);

		System.out.println(pedido);
		System.out.println(os2);

	}

}
