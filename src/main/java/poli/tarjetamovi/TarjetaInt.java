package poli.tarjetamovi;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by juancho on 19/10/16.
 */
public interface TarjetaInt {
    Boleto pagar(Transporte transporte, LocalDateTime fecha, String tipo);
    void recargar(Double monto);
    Double getSaldo();
    List<Viaje> getViajes();
}
