package poli.tarjetamovi;
/**
 * Created by juancho on 30/06/16.
 */
public class Bicicleta implements Transporte{
    String nroSerie;
    BaseBoletos baseBoletos;

    public Bicicleta(String nroSerie, BaseBoletos baseBoletos) {
        this.nroSerie = nroSerie;
        this.baseBoletos = baseBoletos;
    }

    public Double getValorBoleto(){
        return baseBoletos.getUrbano()*1.5;
    }

    public BaseBoletos getBaseBoletos() {
        return baseBoletos;
    }

    public String getNombre() {
        return "Bicicleta " + nroSerie;
    }

    public void setBaseBoletos(BaseBoletos baseBoletos) {
        this.baseBoletos = baseBoletos;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }
}
