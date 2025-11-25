package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Forma;
import entidades.Retangulo;
import entidades.Circulo;
import entidades.enums.Cor;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Forma> lista = new ArrayList<>();
		
		System.out.println("Digite o numero de formas: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Informações da Forma número " +i+ ":");
			System.out.print("Retangulo ou Circulo (r/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Cor (PRETO/AZUL/VERMELHO): ");
			Cor cor = Cor.valueOf(sc.next());
			if(ch == 'r') {
				System.out.print("Lagura: ");
				double largura = sc.nextDouble();
				System.out.print("Altura: ");
				double altura = sc.nextDouble();
				lista.add(new Retangulo(cor, largura, altura));
			}
			else {
				System.out.print("Raio: ");
				double raio = sc.nextDouble();
				lista.add(new Circulo(cor, raio));
			}
			
		}
		System.out.println();
		System.out.println("Área das formas:");
		for(Forma forma:lista) {
			System.out.println(String.format("%.2f", forma.area()));
		}
		
		sc.close();
	}

}
