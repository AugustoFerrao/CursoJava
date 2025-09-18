package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

import entidades.Departamento;
import entidades.HorasContrato;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome do Departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Digite os dados do Trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrabalharor = sc.nextLine();
		System.out.print("Nivel do trabalhador: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Salário base");
		double salarioBase = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(nomeTrabalharor, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos esse trabalhador possui? ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Dados do Contrato #" + i);
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por horas: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (em horas): ");
			int horas = sc.nextInt();
			HorasContrato contrato = new HorasContrato(dataContrato, valorPorHora, horas);
			trabalhador.adicionarContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Digite o mês e o ano para calcular o valor recebido (MM/YYYY): ");
		String mesEAno = sc.next();
		
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Recebido para " + mesEAno + ": " + String.format("%.2f" ,trabalhador.recebido(ano, mes)));
		
		sc.close();
	}

}
