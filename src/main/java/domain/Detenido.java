package domain;

public class Detenido extends EstadoAuto {
    private double temperaturaAlDetenerse = 0.04;

    public Detenido(Auto auto){
        aumentarTemperatura(auto);
        auto.setVelocidadActual(0);
    }

    @Override
    public void acelerar(Auto auto, int kmH) {
        auto.cambiarEstadoA(new EnMovimiento(auto,kmH));
    }

    private void aumentarTemperatura(Auto auto){
        double gradosAaumentar  = this.temperaturaAlDetenerse * auto.getVelocidadActual();
        auto.aumentarTemperatura(gradosAaumentar);
    }

    @java.lang.Override
    public void apagar(Auto auto) {
        auto.cambiarEstadoA(new Apagado(auto));
    }
}
