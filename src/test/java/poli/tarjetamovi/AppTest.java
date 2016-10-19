package poli.tarjetamovi;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public void testTarjeta()
    {   Tarjeta tarjeta = new Tarjeta();
        tarjeta.recargar(100.0);
        ColectivoUrbano colectivoUrbano = new ColectivoUrbano("144 Rojo", new BaseBoletos(8.5, 11.5));
        assertEquals(100.0, tarjeta.saldo);
        tarjeta.pagar(colectivoUrbano, "2016-06-30T23:10:00");
        assertEquals(91.5, tarjeta.saldo);
    }
}
