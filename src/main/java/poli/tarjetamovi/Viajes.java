package poli.tarjetamovi;

import java.time.LocalDateTime;

/**
 * Created by juancho on 30/06/16.
 */
public class Viajes {
    private String transporteNombre;
    private Double costo;
    private LocalDateTime fechaHora;

    public Viajes(String transporteNombre, Double costo, LocalDateTime fechaHora){
        this.transporteNombre = transporteNombre;
        this.costo = costo;
        this.fechaHora = fechaHora;
    }

    public Double getCosto() {
        return costo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getTransporteNombre() {
        return transporteNombre;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setTransporteNombre(String transporteNombre) {
        this.transporteNombre = transporteNombre;
    }

    @Override
    public String toString() {
        return transporteNombre + " " + costo + " " + fechaHora;
    }
}
