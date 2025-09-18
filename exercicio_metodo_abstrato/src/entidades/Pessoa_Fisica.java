package entidades;

public class Pessoa_Fisica extends Contribuinte{
	
	private Double gastosSaude;
	
	public Pessoa_Fisica() {
	}

	public Pessoa_Fisica(String nome, Double ganhoAnual, Double gastosSaude) {
		super(nome, ganhoAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public double taxa() {

		double taxaBasica;
		if(getGanhoAnual() < 20000) {
			taxaBasica = getGanhoAnual() * 0.15;
		}
		else {
			taxaBasica = getGanhoAnual() * 0.25;
		}
		
		taxaBasica -= getGastosSaude() * 0.5;
		if(taxaBasica < 0) {
			taxaBasica = 0;
		}
		return taxaBasica;
	}
}