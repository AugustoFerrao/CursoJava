package aula_datahora_local_para_global;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Main {

	public static void main(String[] args) {
		
		LocalDate d04 = LocalDate.parse("2024-02-15");
		LocalDateTime d05 = LocalDateTime.parse("2024-02-15T01:10:12");
		Instant d06 = Instant.parse("2024-02-15T01:10:12Z");
		
		LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
		LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
		LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
		LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

		System.out.println("r1 = "+ r1);
		System.out.println("r2 = "+ r2);
		System.out.println("r3 = "+ r3);
		System.out.println("r4 = "+ r4);
		
		System.out.println("d04 dia = "+ d04.getDayOfMonth());
		System.out.println("d04 mês = "+ d04.getMonthValue());
		System.out.println("d04 ano = "+ d04.getYear());
		
		System.out.println("d05 hora = "+ d05.getHour());
		System.out.println("d05 hora = "+ d05.getMinute());
		
		//calculos com data e hora
			
		LocalDate semanaPassadaLocalDate = d04.minusDays(7);
		LocalDate proximaSemanaLocalDate = d04.plusDays(7);
		LocalDate proximaDecadaLocalDate = d04.plusYears(10);
		
		LocalDateTime semanaPassadaLocalDateTime = d05.minusDays(7);
		LocalDateTime proximaSemanaLocalDateTime = d05.plusDays(7);
		
		// com o LocalDateTime = igual ao LocalDate mas tem a parte de hora.
		//com o instante é um pouco diferente 
		
		Instant	semanaPassadaInstant = d06.minus(7, ChronoUnit.DAYS);
		Instant proximaSemanaInstant = d06.plus(10, ChronoUnit.DAYS);
		
		System.out.println();
		System.out.println("Semana Atual d04 = "+ d04  + ".");
		System.out.println("Semana Passada d04 = " + semanaPassadaLocalDate + ".");
		System.out.println("Próxima Semana d04 = " + proximaSemanaLocalDate + ".");
		System.out.println("Próxima Década d04 = " + proximaDecadaLocalDate + ".");
		
		System.out.println();
		System.out.println("Semana Atual d05 = "+ d05  + ".");
		System.out.println("Semana Passada d05 = " + semanaPassadaLocalDateTime + ".");
		System.out.println("Próxima Semana d05 = " + proximaSemanaLocalDateTime + ".");
		
		System.out.println();
		System.out.println("Semana Atual d06 = "+ d06  + ".");
		System.out.println("Semana Passada d06 = "+ semanaPassadaInstant  + ".");
		System.out.println("Próxima Semana d06 = "+ proximaSemanaInstant  + ".");
		
		/*lembrando que o duration precisa de um tempo que o LocalDate não possui 
		 por isso que temos que usar o .atStartOfDay para definir o tempo para o inicio do dia */
		
		Duration t1 = Duration.between(semanaPassadaLocalDate.atStartOfDay(), d04.atStartOfDay());
		Duration t2 = Duration.between(semanaPassadaLocalDateTime, d05);
		Duration t3 = Duration.between(semanaPassadaInstant, d06);
		
		System.out.println();
		System.out.println("t1 dias = " + t1.toDays()+ " dias.");
		System.out.println("t2 dias = " + t2.toDays()+ " dias.");
		System.out.println("t3 dias = " + t3.toDays()+ " dias.");
		
	}

}
