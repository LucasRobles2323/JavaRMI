package client;

public class PriceFlight {
	private double oneUF;
	
	public void getOneUF(double pesosOneUF) 
	{
		this.oneUF = pesosOneUF;
	}
	
	public double UFtoPesos(double uf) 
	{
		return (uf * this.oneUF);
	}
	
	public double PesosToUF(double pesos)
	{
		return (pesos / this.oneUF);
	}

}
