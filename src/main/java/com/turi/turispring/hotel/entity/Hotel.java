package com.turi.turispring.hotel.entity;

import com.turi.turispring.propietario.entity.Propietario;
import com.turi.turispring.reserva.entity.Reserva;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Integer hotelId;
    private String nombre;
    @Column(name = "numero_habitaciones")
    private Integer numeroHabitaciones;
    private String descripcion;
    private Integer calificacion;
    private String direccion;
    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propietario_hotel_id",referencedColumnName = "propietario_id")
    private Propietario propietario;
    public Hotel() {
    }

    public Hotel(Integer hotelId, String nombre, Integer numeroHabitaciones, String descripcion, Integer calificacion, String direccion, List<Reserva> reservas, Propietario propietario) {
        this.hotelId = hotelId;
        this.nombre = nombre;
        this.numeroHabitaciones = numeroHabitaciones;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.direccion = direccion;
        this.reservas = reservas;
        this.propietario = propietario;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(Integer numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}
