package poli.tarjetamovi;

import java.time.LocalDateTime;

/**
 * Created by juancho on 19/10/16.
 */
public class Transporte {
    private Lector lector;

    public Boleto cobrar(Tarjeta tarjeta, LocalDateTime fecha, String tipo){
        Boleto boleto = lector.apoyarTarjeta(tarjeta, fecha, tipo);
        return boleto;
    }
}
