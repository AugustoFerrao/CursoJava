package programa;

import java.util.Locale;
import java.util.Scanner;

import aluno.Aluno;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Aluno aluno = new Aluno();
		
		System.out.println("Digite o nome do aluno:");
		aluno.nome = sc.nextLine();
		System.out.println("Digite as 3 notas do aluno:");
		aluno.nota1 = sc.nextDouble();
		aluno.nota2 = sc.nextDouble();
		aluno.nota3 = sc.nextDouble();
		
		System.out.println("A média final do Aluno - " + aluno.nome + " é " + aluno.media() + ".");
		
		if(aluno.media()>60) {
			System.out.println("Passou de Ano");
		}
		else {
			System.out.println("Perdeu de ano faltando " +(60 - aluno.media()) + " pontos.");
		}
		sc.close();
	}

}
