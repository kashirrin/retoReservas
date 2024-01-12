package main.java.com.retoreserva.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Este tipo de generación asume que la base de datos asignará automáticamente un valor único a la clave primaria
    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Long idHabitacionSala;
    private String nombreCliente;
    private String estadoReserva;

    // Constructor por defecto necesario para JPA
    public Reserva() {
    }

    // Constructor parametrizado
    public Reserva(LocalDateTime fechaInicio, LocalDateTime fechaFin, Long idHabitacionSala, String nombreCliente, String estadoReserva) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idHabitacionSala = idHabitacionSala;
        this.nombreCliente = nombreCliente;
        this.estadoReserva = estadoReserva;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Long getIdHabitacionSala() {
        return idHabitacionSala;
    }

    public void setIdHabitacionSala(Long idHabitacionSala) {
        this.idHabitacionSala = idHabitacionSala;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
}

