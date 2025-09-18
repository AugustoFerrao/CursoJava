package aula_datahora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;
		
		LocalDate d01 = LocalDate.now();
		LocalDateTime d02 = LocalDateTime.now();
		Instant d03 = Instant.now();
		
		LocalDate d04 = LocalDate.parse("2024-02-15");
		LocalDateTime d05 = LocalDateTime.parse("2024-02-15T10:15:26");
		Instant d06 = Instant.parse("2024-02-15T10:21:15Z");
		Instant d07 = Instant.parse("2024-02-15T10:21:15-03:00");
		
		LocalDate d08 = LocalDate.parse("15/02/2024", fmt1);
		LocalDateTime d09 = LocalDateTime.parse("15/02/2024 10:30", fmt2);
		
		LocalDate d10 = LocalDate.of(2040, 2, 15);
		LocalDateTime d11 = LocalDateTime.of(2024, 2, 15, 10, 36);
		
		System.out.println("d01 = "+ d01);
		System.out.println("d02 = "+ d02);
		System.out.println("d03 = "+ d03);
		System.out.println("d04 = "+ d04);
		System.out.println("d05 = "+ d05);
		System.out.println("d06 = "+ d06);
		System.out.println("d07 = "+ d07);
		System.out.println("d08 = "+ d08);
		System.out.println("d09 = "+ d09);
		System.out.println("d10 = "+ d10);
		System.out.println("d11 = "+ d11);
		System.out.println("d04 formatado = "+ d04.format(fmt1));
		System.out.println("d05 formatado = "+ d05.format(fmt2));
		System.out.println("d01 formatado = "+ d01.format(fmt1));
		System.out.println("d02 formatado = "+ d02.format(fmt2));
		System.out.println("d03 formatado = "+ fmt3.format(d03));
		System.out.println("d05 formatado2 = "+ d05.format(fmt4));
		System.out.println("d06 formatado = "+ fmt5.format(d06));

	}

}
