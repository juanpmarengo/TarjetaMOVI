package poli.tarjetamovi;

/**
 * Created by juancho on 30/06/16.
 */
public class Viaje{
    private Boleto boleto;

    public Viaje(Boleto boleto) {
        this.boleto = boleto;
    }

    public Boleto getBoleto(){
        return boleto;
    }

    public String getTipo(){
        return boleto.getTransporte().getClass().getSimpleName();
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
                "tipo='" + boleto.getTransporte().getClass().getSimpleName() + '\'' +
                ", monto=" + boleto.getMonto() +
                ", transporte='" + boleto.getTransporte().toString() + '\'' +
                '}';
    }
}
