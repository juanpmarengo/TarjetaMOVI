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
    private Colectivo colectivo2;
    private Bicicleta bicicleta;

    protected void setUp(){
        tarjeta = new Tarjeta();
        colectivo = new Colectivo("144 Negro", "Rosario Bus");
        colectivo2 = new Colectivo("35/9 Verde", "Rosario Bus");
        bicicleta = new Bicicleta("Bicicleta 1", "EMR");
    }

    protected void tearDown(){
        tarjeta = new Tarjeta();
        colectivo = new Colectivo("144 Negro", "Rosario Bus");
        bicicleta = new Bicicleta("Bicicleta 1", "EMR");
    }

    public void testApp(){
        App app = new App();
        try{
            app.main(new String[1]);
        }
        catch (Exception exception){
            assertEquals(null, exception);
        }
        Constants constants = new Constants();
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

        tarjeta.pagar(colectivo, LocalDateTime.parse("2016-07-02T08:10:00"), NORMAL);

        assertEquals(96.0, tarjeta.getSaldo());

        tarjeta.pagar(colectivo, LocalDateTime.parse("2016-07-03T08:10:00"), MEDIO);

        assertEquals(94.0, tarjeta.getSaldo());

        tarjeta.pagar(colectivo, LocalDateTime.parse("2016-07-04T08:10:00"), GRATIS);

        assertEquals(94.0, tarjeta.getSaldo());

        tarjeta.pagar(bicicleta, LocalDateTime.parse("2016-07-05T08:10:00"), MEDIO);

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

    public void testViajesPlus(){
        tarjeta.pagar(colectivo, LocalDateTime.parse("2016-07-02T08:10:00"), NORMAL);
        assertEquals(0.0, tarjeta.getSaldo());
        Long expected = 1L;
        assertEquals(expected, tarjeta.getViajesPlus());

        tarjeta.pagar(bicicleta, LocalDateTime.parse("2016-07-03T08:10:00"), NORMAL);
        assertEquals(0.0, tarjeta.getSaldo());
        expected--;
        assertEquals(expected, tarjeta.getViajesPlus());

        Boleto boleto = tarjeta.pagar(bicicleta, LocalDateTime.parse("2016-07-04T08:10:00"), NORMAL);
        assertEquals(null, boleto);

        boleto = tarjeta.pagar(colectivo, LocalDateTime.parse("2016-07-05T08:10:00"), NORMAL);
        assertEquals(null, boleto);

        tarjeta.recargar(20.0);
        assertEquals(20.0, tarjeta.getSaldo());

        tarjeta.pagar(colectivo, LocalDateTime.parse("2016-07-06T08:10:00"), MEDIO);

        assertEquals(2.0, tarjeta.getSaldo());

        expected = 2L;
        assertEquals(expected, tarjeta.getViajesPlus());
    }

    public void testBoleto(){
        Boleto boleto = tarjeta.pagar(colectivo, LocalDateTime.MAX, NORMAL);
        assertEquals(LocalDateTime.MAX, boleto.getFecha());
        assertEquals(tarjeta.getSaldo(), boleto.getSaldo());
        assertEquals(tarjeta, boleto.getTarjeta());
    }

    public void testViaje(){
        tarjeta.pagar(colectivo, LocalDateTime.MAX, NORMAL);
        Viaje viaje = tarjeta.getViajes().get(0);
        assertEquals(colectivo, viaje.getTransporte());
        assertEquals("Colectivo", viaje.getTipo());
    }

    public void testTrasbordo60(){
        tarjeta.recargar(500.0);
        tarjeta.pagar(colectivo, LocalDateTime.parse("2016-07-05T08:10:00"), NORMAL);
        Boleto boleto = tarjeta.pagar(colectivo2, LocalDateTime.parse("2016-07-05T08:50:00"), NORMAL);

        assertEquals(TRASBORDO, boleto.getTipo());
    }

    public void testTrasbordo90(){
        tarjeta.recargar(500.0);
        tarjeta.pagar(colectivo, LocalDateTime.parse("2016-07-09T14:10:00"), NORMAL);
        Boleto boleto = tarjeta.pagar(colectivo2, LocalDateTime.parse("2016-07-09T15:30:00"), NORMAL);

        assertEquals(TRASBORDO, boleto.getTipo());
    }

    public void testTrasbordoTrasbordo(){
        tarjeta.recargar(500.0);
        tarjeta.pagar(colectivo, LocalDateTime.parse("2016-07-09T14:10:00"), NORMAL);
        tarjeta.pagar(colectivo2, LocalDateTime.parse("2016-07-09T15:30:00"), NORMAL);
        Boleto boleto = tarjeta.pagar(colectivo, LocalDateTime.parse("2016-07-09T15:50:00"), NORMAL);

        assertEquals(NORMAL, boleto.getTipo());
    }

    public void testTrasbordoMismoColectivo(){
        tarjeta.recargar(500.0);
        tarjeta.pagar(colectivo, LocalDateTime.parse("2016-07-09T14:10:00"), NORMAL);
        Boleto boleto = tarjeta.pagar(colectivo, LocalDateTime.parse("2016-07-09T15:30:00"), NORMAL);

        assertEquals(NORMAL, boleto.getTipo());
    }
}
