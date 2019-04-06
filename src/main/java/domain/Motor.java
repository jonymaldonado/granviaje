package domain;

import com.sun.jmx.snmp.Timestamp;

public class Motor {
	private double temperatura = 0.0;
	private double limiteTemperaturaMaxima = 95.0;
	private double consumoPromedio = 133.0;

	public void apagar(){
		this.temperatura = 0.0;
	}

	public void aumentarTemperatura(Auto auto, double grados) {
		this.temperatura += grados;
		enfriarSiEsNecesario(auto);
	}

	private void enfriarSiEsNecesario(Auto auto){
		if (this.temperatura >= this.limiteTemperaturaMaxima) {
			auto.enfriar();
		}
	}

	public void disminuirTemperatura(double grados){
		this.temperatura -= grados;
	}

	public void consumirCombustible(Auto auto, double litros){
		auto.getTanqueDeCombustible().consumir(litros);
	}

	public void desplazar(Auto auto){
		Timestamp ahora = new Timestamp(System.currentTimeMillis());
		double intervalo = (ahora.getDate().getTime() - auto.getTimeStampVelocidadActual().getDate().getTime()) * 0.001;
		double kms = intervalo * (velocidadEnSegundos(auto.getVelocidadActual()));
		auto.getTanqueDeCombustible().consumir(kms * consumoPromedioEnLitros());
	}

	private double velocidadEnSegundos(double velocidad){
		return velocidad / 3600;
	}

	private double consumoPromedioEnLitros(){
		return this.consumoPromedio / 1000;
	}
}
