package conversor;

public class Conversor {

	public static double IOF = 0.06;
	
	public static double dolarParaReal(double cotacaoDolar, double quantosDolars) {
		return cotacaoDolar * quantosDolars * (1.0 + IOF);
		
	}
}
