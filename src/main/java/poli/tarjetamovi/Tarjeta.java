package poli.tarjetamovi;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by juancho on 19/10/16.
 */
public class Tarjeta implements  TarjetaInt{
    private Double saldo;
    private List<Viaje> viajes;

    public Tarjeta(){
        viajes = new LinkedList<>();
        saldo = 0.0;
    }

    @Override
    public Boleto pagar(Transporte transporte, LocalDateTime fecha, String tipo) {
        Boleto boleto = transporte.cobrar(this, fecha, tipo);

        if (boleto != null){
            Viaje viaje = new Viaje(boleto);
            viajes.add(viaje);
        }

        return boleto;
    }

    public void recargar(Double monto){
        if (monto < 272) saldo =  saldo + monto;
        else if (monto < 500) saldo = saldo + monto + 48;
        else saldo = saldo + monto + 140;
    }

    public Double getSaldo() {
        return saldo;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }
}
