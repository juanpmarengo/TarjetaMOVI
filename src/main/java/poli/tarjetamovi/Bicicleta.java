package poli.tarjetamovi;

import java.time.LocalDateTime;

import static poli.tarjetamovi.Constants.*;

/**
 * Created by juancho on 19/10/16.
 */
public class Bicicleta extends TransporteAbs{
    public Bicicleta(String nombre, String empresa) {
        super(nombre, empresa);
    }

    @Override
    public Boleto cobrar(Tarjeta tarjeta, LocalDateTime fecha, String tipo) {
        Double monto = BICI_VALOR;

        if(tarjeta.getSaldo() > monto){
            tarjeta.descargar(monto);
            return new Boleto(fecha, NORMAL, monto, tarjeta, this);
        }

        if(tarjeta.getViajesPlus() > 0){
            tarjeta.descargarViajePlus();
            return new Boleto(fecha, PLUS, monto, tarjeta, this);
        }

        System.out.print("Tu tarjeta no tiene saldo ni viajes plus para este boleto.");
        return null;
    }
}
