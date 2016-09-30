package poli.tarjetamovi;

/**
 * Created by juancho on 30/06/16.
 */
public class ColectivoInter extends ColectivoAbs{
    public ColectivoInter(String nombre, BaseBoletos baseBoletos){
        super(nombre, baseBoletos);
    }
    public Double getValorBoleto() {
        return baseBoletos.getInterUrbano();
    }
}
