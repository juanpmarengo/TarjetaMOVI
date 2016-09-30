package poli.tarjetamovi;

/**
 * Created by juancho on 30/06/16.
 */
public abstract class ColectivoAbs implements Transporte{
    String nombre;
    BaseBoletos baseBoletos;

    public ColectivoAbs(String nombre, BaseBoletos baseBoletos){
        this.nombre =  nombre;
        this.baseBoletos = baseBoletos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBaseBoletos(BaseBoletos baseBoletos) {
        this.baseBoletos = baseBoletos;
    }

    public BaseBoletos getBaseBoletos() {
        return baseBoletos;
    }
}
