package poli.tarjetamovi;

import java.time.LocalDateTime;

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
            return new Boleto(fecha, NORMAL, monto, tarjeta, this);
        }

        if(tarjeta.getViajesPlus() > 0){
            tarjeta.descargarViajePlus();
            return new Boleto(fecha, PLUS, monto, tarjeta, this);
        }

        System.out.print("Tu tarjeta no tiene saldo ni viajes plus para este boleto.");
        return null;
    }

    private Boolean esTrasbordo(Tarjeta tarjeta, LocalDateTime fecha) {
        return false;
    }
}
