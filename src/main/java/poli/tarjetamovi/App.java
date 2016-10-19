package poli.tarjetamovi;

import java.time.LocalDateTime;

import static poli.tarjetamovi.Constants.*;

/**
 * Created by juancho on 30/06/16.
 */
public class App {
    public static void main(String[] args) {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.recargar(272.0);
        System.out.println(tarjeta.getSaldo());
        Colectivo colectivo144Negro = new Colectivo("144 Negro", "Rosario Bus");
        tarjeta.pagar(colectivo144Negro, LocalDateTime.parse("2016-06-30T22:50:00"), MEDIO);
        System.out.println(tarjeta.getSaldo());
        Colectivo colectivo135 = new Colectivo("133", "Rosario Bus");
        tarjeta.pagar(colectivo135, LocalDateTime.parse("2016-06-30T23:10:00"), NORMAL);
        System.out.println(tarjeta.getSaldo());
        Bicicleta bicicleta1 = new Bicicleta("Bicicleta 1", "EMR");
        tarjeta.pagar(bicicleta1, LocalDateTime.parse("2016-07-02T08:10:00"), NORMAL);
        System.out.println(tarjeta.getSaldo());
        for (Viaje viaje : tarjeta.getViajes())
            System.out.println(viaje.toString());

    }
}