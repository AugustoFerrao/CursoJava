package funcoes_string;

public class Main {

	public static void main(String[] args) {
		
		String original ="abcde FGHIJ ABC abc DEFG    ";
		//tudo letra minúscula
		String s1 = original.toLowerCase();
		//tudo letra maiúscula
		String s2 = original.toUpperCase();
		//tira espaços no final
		String s3 = original.trim();
		//cria uma uma nova string apartir de um ponto, podendo ter um final ou não
		String s4 = original.substring(2);
		String s5 = original.substring(2,9);
		//substituição de termos dentro de um string
		String s6 = original.replace('a','x');
		String s7 = original.replace("abc", "xyz");
		//acha a posição de um termo quando ele aparece pela primeira vez
		int posicaoInicial = original.indexOf("bc");
		//acha a posição de um termo quando ele aparece pela última vez
		int posicaoFinal = original.lastIndexOf("bc");
		//vetor string
		String[] vetor = s3.split(" ");
		String palavra1 = vetor[0];
		String palavra2 = vetor[1];
		String palavra3 = vetor[2];
		String palavra4 = vetor[3];
		String palavra5 = vetor[4];
		
		System.out.println("Original: -"+ original +"-");
		System.out.println("toLowerCase: -"+ s1 +"-");
		System.out.println("toUpperCase: -"+ s2 +"-");
		System.out.println("trim: -"+ s3 +"-");
		System.out.println("sub string começando no 2: -"+ s4 +"-");
		System.out.println("sub string começando no 2 e terminando no 9: -"+ s5 +"-");
		System.out.println("replace de a por x: -"+ s6 +"-");
		System.out.println("replace de abc por xyz"+ s7 +"-" );
		System.out.println("código da primeira aparição do termo -bc- :"+ posicaoInicial +" -" );
		System.out.println("código da última aparição do termo -bc- :"+ posicaoFinal +" -" );
		System.out.println("split vetor 0 - " + palavra1 +" -");
		System.out.println("split vetor 1 - " + palavra2 +" -");
		System.out.println("split vetor 2 - " + palavra3 +" -");
		System.out.println("split vetor 3 - " + palavra4 +" -");
		System.out.println("split vetor 4 - " + palavra5 +" -");
		
	}

}
