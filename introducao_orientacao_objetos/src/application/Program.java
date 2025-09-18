package application;

import java.util.Locale;
import java.util.Scanner;

import entidades.Triangulo;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Triangulo x, y;
		x = new Triangulo();
		y = new Triangulo();
		
		System.out.println("Digite as medidas do lado do primeiro triângulo:");
		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();
		System.out.println("Digite as medidas do lado do segundo triângulo:");
		y.a = sc.nextDouble();
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();
		
		System.out.printf("Area do primeiro triângulo é %.4f.%n", x.area());
		System.out.printf("Area do segundo triângulo é %.4f.%n", y.area());
		
		if (x.area() > y.area()) {
			System.out.println("O primeiro triângulo é o maior.");
		}
		else {
			System.out.println("O segundo triângulo é o maior.");
		}
		
		sc.close();

	}

}
