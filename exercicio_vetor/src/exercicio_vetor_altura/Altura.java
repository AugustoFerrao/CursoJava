package exercicio_vetor_altura;

import java.util.Locale;
import java.util.Scanner;

import utilidade.Pessoa;

public class Altura {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int numeroPessoas, pessoasDeMenor;
		double alturaTotal, alturaMedia, percentualMenores;
		
		
		System.out.println("Digite o número de pessoas a serem cadastradas:");
		numeroPessoas = sc.nextInt();
		sc.nextLine();
		
		Pessoa[] pessoas = new Pessoa[numeroPessoas];
		
		for(int i=0; i<pessoas.length; i++) {	
			System.out.printf("Digite os dados da %da pessoa:\n", i+1);
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Idade: ");
			int idade = sc.nextInt();
			System.out.print("Altura: ");
			double altura = sc.nextDouble();
			pessoas[i] = new Pessoa(nome, idade, altura);
			sc.nextLine();
		}
		
		pessoasDeMenor = 0;
		alturaTotal = 0;
		
		for(int i=0; i<pessoas.length; i++) {
			if(pessoas[i].getIdade() < 16) {
				pessoasDeMenor++;
			}
			alturaTotal = alturaTotal + pessoas[i].getAltura();
		}
		
		alturaMedia = alturaTotal / pessoas.length;
		percentualMenores = ((double)pessoasDeMenor / pessoas.length) * 100;
		
		System.out.printf("Altura média = %.2f%n", alturaMedia);
		System.out.printf("Pessoas com menos de 16 anos: %.1f%%n", percentualMenores);
		System.out.println("Nomes das pessoas com menos de 16 anos:");
		
		for(int i=0; i<pessoas.length; i++) {
			if(pessoas[i].getIdade() < 16) {
				System.out.println("" + pessoas[i].getNome());
			}
		}
		
		sc.close();

	}

}
