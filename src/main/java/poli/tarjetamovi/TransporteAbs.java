package poli.tarjetamovi;

/**
 * Created by juancho on 19/10/16.
 */
public abstract class TransporteAbs implements Transporte {
    private String nombre;
    private String empresa;

    public TransporteAbs(String nombre, String empresa) {
        this.nombre = nombre;
        this.empresa = empresa;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getEmpresa() {
        return empresa;
    }

    @Override
    public Long getNumeroLinea() {
        return Long.valueOf(this.hashCode());
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "nombre='" + nombre + '\'' +
                ", empresa='" + empresa + '\'' +
                '}';
    }
}
