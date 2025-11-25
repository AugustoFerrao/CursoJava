package bloco_finally;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		File file = new File("C:\\temp\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Error ao abrir o arquivo: " + e.getMessage());
		}
		finally {
			if(sc != null) {
				sc.close();
			}
			//para testar se o bloco finally está sendo executado
			System.out.println("bloco finally executado");
		}
	}
}
