package poli.tarjetamovi;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by juancho on 30/06/16.
 */
public abstract class TarjetaAbs implements TarjetaInt{
    protected Double saldo;
    protected List<Viajes> viajes;

    public TarjetaAbs(){
        viajes = new LinkedList<>();
        saldo = new Double(0);
    }

    public void recargar(Double monto){
        if (monto < 272) saldo =  saldo + monto;
        else if (monto < 500) saldo = saldo + monto + 48;
        else saldo = saldo + monto + 140;
    }

    public void saldo(){
        System.out.println(saldo);
    }

    public void viajesRealizados(){
        for (Viajes viaje : viajes){
            System.out.println(viaje.toString());
        }
    }
}
