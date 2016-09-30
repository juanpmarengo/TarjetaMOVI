package poli.tarjetamovi;

/**
 * Created by juancho on 30/06/16.
 */
public class App {
    public static void main(String[] args) {
        Medio medio = new Medio();
        medio.recargar(new Double(272));
        medio.saldo();
        BaseBoletos baseBoletos =  new BaseBoletos(new Double(8), new Double(10)); // Base de datos con los precios de los boletos urbanos e interurbanos
        ColectivoUrbano colectivo144Negro = new ColectivoUrbano("144 Negro", baseBoletos);
        medio.pagar(colectivo144Negro, "2016-06-30T22:50:00");
        medio.saldo();
        ColectivoUrbano colectivo135 = new ColectivoUrbano("135", baseBoletos);
        medio.pagar(colectivo135, "2016-06-30T23:10:00");
        medio.saldo();
        Bicicleta bicicleta = new Bicicleta("ABC123", baseBoletos);
        medio.pagar(bicicleta, "2016-07-02T08:10:00");
        medio.viajesRealizados(); //Hago el foreach directamente en el metodo
    }
}