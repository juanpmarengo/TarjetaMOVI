package poli.tarjetamovi;

/**
 * Created by juancho on 30/06/16.
 */
public class ColectivoUrbano extends ColectivoAbs{
    public ColectivoUrbano(String nombre, BaseBoletos baseBoletos){
        super(nombre, baseBoletos);
    }
    public Double getValorBoleto() {
        return baseBoletos.getUrbano();
    }
}
