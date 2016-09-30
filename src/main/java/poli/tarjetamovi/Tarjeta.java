package poli.tarjetamovi;

import java.time.LocalDateTime;

/**
 * Created by juancho on 30/06/16.
 */
public class Tarjeta extends TarjetaAbs{

    public void pagar(Transporte transporte, String fechaHoraString){
        LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraString);
        Double costo;
        if(viajes != null && viajes.size()>0 && transporte.getNombre() != viajes.get(viajes.size()-1).getTransporteNombre() && fechaHora.minusHours(1).isBefore(viajes.get(viajes.size()-1).getFechaHora())){
            costo = 2.64;
        }
        else {
            costo = transporte.getValorBoleto();
        }
        if (costo > saldo) System.out.println("Saldo insuficiente.");
        else {
            saldo = saldo - costo;
            viajes.add(new Viajes(transporte.getNombre(), costo, fechaHora));
        }
    }
}
