package poli.tarjetamovi;

/**
 * Created by juancho on 30/06/16.
 */
public interface TarjetaInt {
    void pagar(Transporte transporte, String fechaHoraString);
    void recargar(Double monto);
    void saldo();
    void viajesRealizados();
}
