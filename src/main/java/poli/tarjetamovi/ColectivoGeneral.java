package poli.tarjetamovi;

/**
 * Created by juancho on 30/06/16.
 */
public class ColectivoGeneral extends ColectivoAbs{
    private String clase;

    public ColectivoGeneral(String nombre, String clase, BaseBoletos baseBoletos){
        super(nombre, baseBoletos);
        this.clase = clase;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Double getValorBoleto() {
        return baseBoletos.getValorBoleto(clase);
    }
}
