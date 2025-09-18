package aula_laco_for_each;

public class Main {

	public static void main(String[] args) {
		
		String[] vetor = new String[] {"Maria", "Bob", "Alex"};
		
		for (int i = 0; i<vetor.length; i++) {
			System.out.println(vetor[i]);
		}
		
		System.out.println("---------------");
		
		for(String nomes : vetor) {
			System.out.println(nomes);
		}
		
	}

}
