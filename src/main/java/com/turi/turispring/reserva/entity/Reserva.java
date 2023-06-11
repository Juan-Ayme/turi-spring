package com.turi.turispring.reserva.entity;


import com.turi.turispring.cliente.entity.Cliente;
import com.turi.turispring.hotel.entity.Hotel;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_id")
    private Integer ReservaId;
    private Integer precio;
    private LocalDateTime fechaReserva;
    private Integer numeroHabitacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_reserva_id",referencedColumnName = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_reserva_id",referencedColumnName = "hotel_id")
    private Hotel hotel;

    public Reserva() {
    }
    public Reserva(Integer reservaId, Integer precio, LocalDateTime fechaReserva, Integer numeroHabitacion, Cliente cliente, Hotel hotel) {
        ReservaId = reservaId;
        this.precio = precio;
        this.fechaReserva = fechaReserva;
        this.numeroHabitacion = numeroHabitacion;
        this.cliente = cliente;
        this.hotel = hotel;
    }

    public Integer getReservaId() {
        return ReservaId;
    }

    public void setReservaId(Integer reservaId) {
        ReservaId = reservaId;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Integer getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
