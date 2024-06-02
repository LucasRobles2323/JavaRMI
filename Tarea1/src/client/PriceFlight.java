package client;

public class PriceFlight {
	private double oneUF;
	
	public PriceFlight(Object[] ufValues) 
	{
		if(ufValues == null) 
		{
			System.out.println("Hubo un error, no llego nada de la API");
		} 
		else 
		{
			String codigo = (String) ufValues[0];
			String nombre = (String) ufValues[1];
			String fecha = (String) ufValues[2];
			String unidad_medida = (String) ufValues[3];
			double valor = (double) ufValues[4];
			this.oneUF = valor;
			
			System.out.println("Los valores obtenidos para la UF son:");
			System.out.println("    Codigo: "+ codigo + "\n    Nombre: " + nombre);
			System.out.println("    Fecha: " + fecha + " ");
			System.out.println("    Unidad de Medida: " + unidad_medida + "\n    Valor: " + valor);
		}
	}
	
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
