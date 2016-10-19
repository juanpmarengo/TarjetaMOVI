package poli.tarjetamovi;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static poli.tarjetamovi.Constants.*;

/**
 * Created by juancho on 19/10/16.
 */
public class Tarjeta implements TarjetaInt{
    private Double saldo;
    private List<Viaje> viajes;
    private Long viajesPlus;

    public Tarjeta(){
        viajes = new LinkedList<>();
        saldo = 0.0;
        viajesPlus = 2L;
    }

    public Boleto pagar(Transporte transporte, LocalDateTime fecha, String tipo) {
        Boleto boleto = transporte.cobrar(this, fecha, tipo);

        if (boleto != null){
            Viaje viaje = new Viaje(boleto);
            viajes.add(viaje);
        }

        return boleto;
    }

    public void recargar(Double monto){
        if (monto < 272)
            saldo =  saldo + monto;
        else if (monto < 500)
            saldo = saldo + monto + 48;
        else
            saldo = saldo + monto + 140;

        List<Viaje> viajes = getLastViajesPlus(2 - viajesPlus);

        for (Viaje viaje : viajes){
            if (viaje.getMonto() <= saldo){
                saldo -= viaje.getMonto();
                viajesPlus++;
            }
            else
                break;
        }
    }

    private List<Viaje> getLastViajesPlus(long l) {
        List<Viaje> viajes = new LinkedList<>();

        int x = this.viajes.size();

        for (; l > 0; x--){
            Viaje viaje = this.viajes.get(x);
            if(viaje.getTipo().equals(PLUS)){
                viajes.add(0, viaje);
                l--;
            }
        }

        return viajes;
    }

    public Long getTarjetaId() {
        return Long.valueOf(this.hashCode());
    }

    public Double getSaldo() {
        return saldo;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void descargar(Double monto) {
        saldo -= monto;
    }

    public Long getViajesPlus() {
        return viajesPlus;
    }

    public void descargarViajePlus() {
        viajesPlus -= 1;
    }
}
