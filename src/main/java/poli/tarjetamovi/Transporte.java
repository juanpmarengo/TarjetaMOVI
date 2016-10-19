package poli.tarjetamovi;

import java.time.LocalDateTime;

/**
 * Created by juancho on 19/10/16.
 */
public interface Transporte {
    String getNombre();
    String getEmpresa();
    Boleto cobrar(Tarjeta tarjeta, LocalDateTime fecha, String tipo);
    Long getNumeroLinea();
}
