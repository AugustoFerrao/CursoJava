package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservado {

	private Integer numeroQuarto;
	private Date dataCheckIn;
	private Date dataCheckOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservado(Integer numeroQuarto, Date dataCheckIn, Date dataCheckOut){
		if (!dataCheckOut.after(dataCheckIn)) {
			throw new DomainException("Error ao realizar a reserva: A data de Check-out tem que ser depois da data de Check-in.");
		}
		this.numeroQuarto = numeroQuarto;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataCheckIn() {
		return dataCheckIn;
	}

	public Date getDataCheckout() {
		return dataCheckOut;
	}
	
	public long duracao() {
		long diferenca = dataCheckOut.getTime() - dataCheckIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date dataCheckIn, Date dataCheckOut){
		Date agora = new Date();
		if(dataCheckIn.before(agora) || dataCheckOut.before(agora)) {
			throw new DomainException("Error ao atualizar a reserva: As datas da reserva para atualização tem que ser datas futuras.");
		}
		if (!dataCheckOut.after(dataCheckIn)) {
			throw new DomainException("Error ao realizar a reserva: A data de Check-out tem que ser depois da data de Check-in.");
		}
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
	}
	
	@Override
	public String toString() {
		return "Quarto "
			+ numeroQuarto
			+", check-in: "
			+sdf.format(dataCheckIn)
			+", check-out: "
			+sdf.format(dataCheckOut)
			+", "
			+duracao()
			+" noites";
	}
}
