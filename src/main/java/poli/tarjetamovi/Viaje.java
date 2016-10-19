package poli.tarjetamovi;

/**
 * Created by juancho on 30/06/16.
 */
public class Viaje{
    private Boleto boleto;

    public Viaje(Boleto boleto) {
        this.boleto = boleto;
    }

    public String getTipo(){
        return boleto.getTipo();
    }

    public Transporte getTransporte(){
        return boleto.getTransporte();
    }

    public Double getMonto(){
        return boleto.getMonto();
    }

    @Override
    public String toString() {
        return "Viaje{" +
                " tipo= " + boleto.getTipo() +
                " monto= " + boleto.getMonto() +
                " transporte= " + boleto.getTransporte().toString() +
                '}';
    }
}
