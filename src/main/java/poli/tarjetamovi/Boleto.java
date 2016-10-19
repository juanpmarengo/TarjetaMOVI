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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
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

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
