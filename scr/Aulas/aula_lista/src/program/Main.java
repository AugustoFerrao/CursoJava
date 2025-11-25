package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<String> lista = new ArrayList<>();
		
		lista.add("Maria");
		lista.add("Alex");
		lista.add("Bob");
		lista.add("Barbara");
		lista.add("Anna");
		lista.add(2, "Marco");
		
		for(String x : lista) {
			System.out.println(x);
		}
		//Tamanho de uma lista
		System.out.println(lista.size());
		
		System.out.println("---------------------");
		
		//Lista só com valores começados com A
		List<String> resultado = lista.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList()); 
		
		//Tipos de ação de remoção da lista
		lista.remove("Anna");
		lista.remove(1);
		lista.removeIf(x -> x.charAt(0) == 'B');
		
		for(String x : lista) {
			System.out.println(x);
		}
		
		//Mostrando posições na lista
		System.out.println("posição de Maria: " + lista.indexOf("Maria"));
		System.out.println("posição de Marco: " + lista.indexOf("Marco"));
		
		for(String x : resultado) {
			System.out.println(x);
		}
		
		System.out.println("---------------------");
		
		//Achando o primeiro valor começando com a letra pedida, não encontrando colocando null
		String primeiroNomeA = lista.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
		String primeiroNomeM = lista.stream().filter(x -> x.charAt(0) == 'M').findFirst().orElse(null);
		System.out.println(primeiroNomeA);
		System.out.println(primeiroNomeM);
		
		
		sc.close();
	}		
}
