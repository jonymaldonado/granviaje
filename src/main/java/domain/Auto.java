package domain;

import com.sun.jmx.snmp.Timestamp;
import exceptions.*;

public class Auto {
	private TanqueDeCombustible tanqueDeCombustible;
	private EstadoAuto estado;
	private Motor motor;
	private ElectroVentilador electro;
	private int velocidadActual;
	private Timestamp timeStampVelocidadActual;
	private Recorrido recorridoActual;

	public Motor getMotor(){
		return this.motor;
	}

	public EstadoAuto getEstado() { return this.estado; }

	public void setVelocidadActual(int velocidad){
		this.velocidadActual = velocidad;
		this.timeStampVelocidadActual = new Timestamp(System.currentTimeMillis());
	}

	public void setMotor(Motor unMotor){
		this.motor = unMotor;
	}

	public void setElectro(ElectroVentilador electro){
		this.electro = electro;
	}

	public void setTanqueDeCombustible(TanqueDeCombustible tanque){
		this.tanqueDeCombustible = tanque;
	}

	public int getVelocidadActual(){
		return this.velocidadActual;
	}

	public Timestamp getTimeStampVelocidadActual() { return this.timeStampVelocidadActual;}

	public void recorrer(double kms){
	    this.recorridoActual.recorrer(kms);
    }

    public TanqueDeCombustible getTanqueDeCombustible() { return this.tanqueDeCombustible; }

	public void comenzarRecorrido(Recorrido recorrido){
	    this.recorridoActual = recorrido;
    }

	public void enfriar(){
		this.electro.enfriar(this);
	}

	public double capacidadMaximaCombustible(){
		return this.tanqueDeCombustible.capacidadMaxima();
	}

	public void aumentarTemperatura(double grados){
		this.motor.aumentarTemperatura(this, grados);
	}

	public void cambiarEstadoA(EstadoAuto estado){
		this.estado = estado;
	}

	public void encender() throws NoSePuedeEncenderException, SinCombustibleException{
		try {
			this.estado.encender(this);
		}
		catch (NoSePuedeEncenderException exception){
			throw exception;
		}
		catch (SinCombustibleException exception){
			throw  exception;
		}
	}
	
	public void apagar() throws NoSePuedeApagarException {
		this.estado.apagar(this);
	}
	
	public void acelerar(int kmH) throws NoSePuedeAcelerarException {
		this.estado.acelerar(this, kmH);
	}
	
	public void detener() throws NoSePuedeDetenerException {
		this.estado.detener(this);
	}

	public void recargarCombustible(double cantidad){
		this.tanqueDeCombustible.recargar(cantidad);
	}
}
