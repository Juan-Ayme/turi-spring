package com.turi.turispring.propietario.entity;

import com.turi.turispring.hotel.entity.Hotel;
import com.turi.turispring.persona.entity.Persona;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "propietario")
public class Propietario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propietario_id")
    private Integer propietarioId;
    private String categoria;
    private String ruc;
    @OneToMany(mappedBy = "propietario",cascade = CascadeType.ALL)
    private List<Hotel> hoteles;//relacionar con la tabla hotel , no se va crear ningun atributo en la tabla propietario
    @OneToOne
    @JoinColumn(name = "persona_propietario_id",referencedColumnName = "persona_id")
    private Persona persona;//relacionar con la tabla persona , si se va crear un atributo en la tabla propietario

    public Propietario() {
    }

    public Propietario(Integer propietarioId, String categoria, String ruc, List<Hotel> hoteles, Persona persona) {
        this.propietarioId = propietarioId;
        this.categoria = categoria;
        this.ruc = ruc;
        this.hoteles = hoteles;
        this.persona = persona;
    }

    public Integer getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(Integer propietarioId) {
        this.propietarioId = propietarioId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public List<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(List<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
