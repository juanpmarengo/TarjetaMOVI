package poli.tarjetamovi;

import junit.framework.TestCase;

import java.time.LocalDateTime;

import static poli.tarjetamovi.Constants.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private Tarjeta tarjeta;
    private Colectivo colectivo;
    private Bicicleta bicicleta;

    protected void setUp(){
        tarjeta = new Tarjeta();
        colectivo = new Colectivo("144 Negro", "Rosario Bus");
        bicicleta = new Bicicleta("Bicicleta 1", "EMR");
    }

    protected void tearDown(){
        tarjeta = new Tarjeta();
        colectivo = new Colectivo("144 Negro", "Rosario Bus");
        bicicleta = new Bicicleta("Bicicleta 1", "EMR");
    }

    public void testApp(){
        try{
            App.main(new String[1]);
        }
        catch (Exception exception){
            assertEquals(null, exception);
        }
    }

    public void testTarjetaRecarga()
    {
        tarjeta.recargar(10.0);

        assertEquals(10.0, tarjeta.getSaldo());

        tarjeta.recargar(272.0);

        assertEquals((10.0 + 272.0 + 48.0), tarjeta.getSaldo());

        tarjeta.recargar(500.0);

        assertEquals((330.0 + 500.0 + 140.0), tarjeta.getSaldo());
    }

    public void testTarjetaPago()
    {
        tarjeta.recargar(100.0);

        tarjeta.pagar(colectivo, LocalDateTime.now(), NORMAL);

        assertEquals(96.0, tarjeta.getSaldo());

        tarjeta.pagar(colectivo, LocalDateTime.now(), MEDIO);

        assertEquals(94.0, tarjeta.getSaldo());

        tarjeta.pagar(colectivo, LocalDateTime.now(), GRATIS);

        assertEquals(94.0, tarjeta.getSaldo());

        tarjeta.pagar(bicicleta, LocalDateTime.now(), MEDIO);

        assertEquals(82.0, tarjeta.getSaldo());
    }

    public void testColectivo(){
        assertEquals("144 Negro", colectivo.getNombre());
        assertEquals("Rosario Bus", colectivo.getEmpresa());
    }

    public void testBicicleta(){
        assertEquals("Bicicleta 1", bicicleta.getNombre());
        assertEquals("EMR", bicicleta.getEmpresa());
    }
}
