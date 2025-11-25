package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comentario;
import entities.Post;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Comentario c1 = new Comentario("Tenha uma boa viagem!!");
		Comentario c2 = new Comentario("WOW que incrivel!!");
		Post p1 = new Post(
				sdf.parse("21/06/2025 10:48:44"),
				"Viagem para a Paris",
				"Estou indo turistar nesse pais maravilhoso!",
				12);
		
		p1.adicionarComentairo(c1);
		p1.adicionarComentairo(c2);
		
		Comentario c3 = new Comentario("Boa noite");
		Comentario c4 = new Comentario("Que a força esteja com vc");
		Post p2 = new Post(
				sdf.parse("22/06/2025 23:42:20"),
				"Boa noite gente",
				"Vejo todos amanhã!",
				5);
		
		p2.adicionarComentairo(c3);
		p2.adicionarComentairo(c4);
		
		System.out.println(p1);
		System.out.println(p2);
		
	}

}
