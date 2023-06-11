package com.turi.turispring.cliente.entity;

import com.turi.turispring.persona.entity.Persona;
import com.turi.turispring.reserva.entity.Reserva;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Integer idCliente;
    private String apellido;
    @Column(name = "tipo_identificacion")
    private Integer tipoIdentificacion;
    private Integer monto;
    @OneToOne
    @JoinColumn(name = "persona_cliente_id",referencedColumnName = "persona_id")
    private Persona persona;
    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Integer tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
