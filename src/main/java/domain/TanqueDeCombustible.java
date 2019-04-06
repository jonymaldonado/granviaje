package domain;

public class TanqueDeCombustible {
	private double capacidadMaxima;
	private double litrosActuales;

	public static TanqueDeCombustible deCapacidad(double capacidadMaxima){
		return new TanqueDeCombustible(capacidadMaxima);
	}

	private TanqueDeCombustible(double capacidadMaxima){
		this.capacidadMaxima = capacidadMaxima;
		this.litrosActuales  = capacidadMaxima;
	}

	public void consumir(double litros){
		this.litrosActuales -= litros;
	}

	public void recargar(double litros){
		this.litrosActuales+= litros;
	}

	public double capacidadMaxima(){
		return this.capacidadMaxima;
	}

	public boolean enReserva(){
		return this.litrosActuales < 0.1 * this.capacidadMaxima;
	}

	public boolean proximoAreserva(){
		return this.litrosActuales < 0.15 * this.capacidadMaxima;
	}

	public double combustibleActual(){
		return this.litrosActuales;
	}
}
