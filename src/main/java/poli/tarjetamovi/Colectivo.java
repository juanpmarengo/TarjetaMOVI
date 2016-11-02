package poli.tarjetamovi;

import java.time.LocalDateTime;
import java.util.List;

import static poli.tarjetamovi.Constants.*;

/**
 * Created by juancho on 19/10/16.
 */
public class Colectivo extends TransporteAbs{

    public Colectivo(String nombre, String empresa) {
        super(nombre, empresa);
    }

    @Override
    public Boleto cobrar(Tarjeta tarjeta, LocalDateTime fecha, String tipo) {

        if (tipo.equals(GRATIS))
            return new Boleto(fecha, tipo, 0.0, tarjeta, this);

        Boolean trasbordo = esTrasbordo(tarjeta, fecha);
        Double monto = BOLETO_VALOR;

        if (tipo.equals(MEDIO))
            monto = monto * 0.5;

        if(trasbordo)
            monto = monto * TRASBORDO_RATIO;

        if(tarjeta.getSaldo() > monto){
            tarjeta.descargar(monto);
            return new Boleto(fecha, trasbordo ? TRASBORDO : tipo, monto, tarjeta, this);
        }

        if(trasbordo)
            monto = monto / TRASBORDO_RATIO;

        if(tarjeta.getViajesPlus() > 0){
            tarjeta.descargarViajePlus();
            return new Boleto(fecha, PLUS, monto, tarjeta, this);
        }

        System.out.print("Tu tarjeta no tiene saldo ni viajes plus para este boleto.");
        return null;
    }

    private Boolean esTrasbordo(Tarjeta tarjeta, LocalDateTime fecha) {
        List<Viaje> viajes = tarjeta.getViajes();

        if(viajes.size() == 0)
            return false;

        Boleto lastBoleto = viajes.get(viajes.size() - 1).getBoleto();

        if (lastBoleto.getTipo().equals(TRASBORDO))
            return false;

        if (lastBoleto.getTransporte().getNombre().equals(this.getNombre()))
            return false;

        if ((lastBoleto.getFecha().getDayOfWeek().getValue() < 6 && lastBoleto.getFecha().getHour() >= 6 && lastBoleto.getFecha().getHour() < 22) ||
            (lastBoleto.getFecha().getDayOfWeek().getValue() == 6 && lastBoleto.getFecha().getHour() >= 6 && lastBoleto.getFecha().getHour() < 14)) {
            return fecha.minusMinutes(60).isBefore(lastBoleto.getFecha());
        }

        return fecha.minusMinutes(90).isBefore(lastBoleto.getFecha());
    }
}
