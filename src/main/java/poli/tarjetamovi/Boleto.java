package poli.tarjetamovi;

import java.time.LocalDateTime;

/**
 * Created by juancho on 19/10/16.
 */
public class Boleto {
    private LocalDateTime fecha;
    private String tipo;
    private Double monto;
    private Double saldo;
    private Tarjeta tarjeta;
    private Transporte transporte;

    public Boleto(LocalDateTime fecha, String tipo, Double monto, Tarjeta tarjeta, Transporte transporte) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
        this.saldo = tarjeta.getSaldo();
        this.tarjeta = tarjeta;
        this.transporte = transporte;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "fecha=" + fecha +
                ", tipo='" + tipo + '\'' +
                ", saldo=" + saldo +
                ", tarjetaId=" + tarjeta.hashCode() +
                ", nroLinea=" + transporte.hashCode() +
                '}';
    }

    public Double getMonto() {
        return monto;
    }
}
