package domain;

public class ElectroVentilador {
	private double gradosQueDisminuye;

	public ElectroVentilador(double gradosQueDisminuye){
		this.gradosQueDisminuye = gradosQueDisminuye;
	}

	public void enfriar(Auto auto){
		auto.getMotor().disminuirTemperatura(this.gradosQueDisminuye);
	}
}
