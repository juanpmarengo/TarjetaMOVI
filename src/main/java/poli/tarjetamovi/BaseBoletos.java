package poli.tarjetamovi;

/**
 * Created by juancho on 30/06/16.
 */
public class BaseBoletos {
    private Double urbano;
    private Double interUrbano;

    public BaseBoletos(Double urbano, Double interUrbano) {
        this.urbano = urbano;
        this.interUrbano = interUrbano;
    }

    public Double getInterUrbano() {
        return interUrbano;
    }

    public Double getUrbano() {
        return urbano;
    }

    public void setInterUrbano(Double interUrbano) {
        this.interUrbano = interUrbano;
    }

    public void setUrbano(Double urbano) {
        this.urbano = urbano;
    }

    public Double getValorBoleto(String clase) {
        if (clase == "Urbano") return urbano;
        else return interUrbano;
    }
}
