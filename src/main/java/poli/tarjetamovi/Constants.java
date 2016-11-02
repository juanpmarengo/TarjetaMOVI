package poli.tarjetamovi;

/**
 * Created by juancho on 19/10/16.
 */
public final class Constants {
    public static final Double BICI_VALOR = 12.0;
    public static final Double BOLETO_VALOR = 4.0;
    public static final Double TRASBORDO_RATIO = 0.67;
    public static final String MEDIO = "Medio";
    public static final String NORMAL = "Normal";
    public static final String GRATIS = "Gratis";
    public static final String PLUS = "Plus";
    public static final String TRASBORDO = "Trasbordo";

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
