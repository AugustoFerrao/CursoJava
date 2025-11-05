package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservado;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data do Check-in (dd/mm/yyyy): ");
		Date dataCheckIn = sdf.parse(sc.next());
		System.out.print("Data do Check-out (dd/mm/yyyy): ");
		Date dataCheckOut = sdf.parse(sc.next());
		
		if (!dataCheckOut.after(dataCheckIn)) {
			System.out.println("Error ao realizar a reserva: A data de Check-out tem que ser depois da data de Check-in");
		}
		else {
			Reservado reserva = new Reservado(numeroQuarto, dataCheckIn, dataCheckOut);
			System.out.println("Dados da Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Digite a data para atualizar a reserva");
			System.out.print("Data do Check-in (dd/mm/yyyy): ");
			dataCheckIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (dd/mm/yyyy): ");
			dataCheckOut = sdf.parse(sc.next());
			
			Date agora = new Date();
			if(dataCheckIn.before(agora) || dataCheckOut.before(agora)) {
				System.out.println("Error ao atualizar a reserva: As datas da reserva para atualização tem que ser datas futuras.");
			}
			else if (!dataCheckOut.after(dataCheckIn)) {
				System.out.println("Error ao realizar a reserva: A data de Check-out tem que ser depois da data de Check-in");
			}
			else {
				reserva.atualizarDatas(dataCheckIn, dataCheckOut);
				System.out.println("Dados da Reserva: " + reserva);
			}
		}
		sc.close();
	}

}
