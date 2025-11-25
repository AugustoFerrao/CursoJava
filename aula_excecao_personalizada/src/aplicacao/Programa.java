package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservado;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		try {
			System.out.print("Número do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data do Check-in (dd/mm/yyyy): ");
			Date dataCheckIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (dd/mm/yyyy): ");
			Date dataCheckOut = sdf.parse(sc.next());
			
			Reservado reserva = new Reservado(numeroQuarto, dataCheckIn, dataCheckOut);
			System.out.println("Dados da Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Digite a data para atualizar a reserva");
			System.out.print("Data do Check-in (dd/mm/yyyy): ");
			dataCheckIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (dd/mm/yyyy): ");
			dataCheckOut = sdf.parse(sc.next());
			
			reserva.atualizarDatas(dataCheckIn, dataCheckOut);
			System.out.println("Dados da Reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Data no formato invalido");
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro não esperado");
		}
		sc.close();
	}

}
