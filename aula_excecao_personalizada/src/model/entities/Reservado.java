package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservado {

	private Integer numeroQuarto;
	private Date dataCheckIn;
	private Date dataCheckout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservado(Integer numeroQuarto, Date dataCheckIn, Date dataCheckout) {
		super();
		this.numeroQuarto = numeroQuarto;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckout = dataCheckout;
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
		return dataCheckout;
	}
	
	public long duracao() {
		long diferenca = dataCheckout.getTime() - dataCheckIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date dataCheckIn, Date dataCheckOut) {
		this.dataCheckIn = dataCheckIn;
		this.dataCheckout = dataCheckOut;
	}
	
	@Override
	public String toString() {
		return "Quarto "
			+ numeroQuarto
			+", check-in: "
			+sdf.format(dataCheckIn)
			+", check-out: "
			+sdf.format(dataCheckout)
			+", "
			+duracao()
			+" noites";
	}
}
