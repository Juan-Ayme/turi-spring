package com.turi.turispring.persona.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "persona")
public class Persona
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    private Integer idPersona;
    private String nombre;
    private String correo;
    @Column(name = "contraseña")
    private String contrasena;
    private String telefono;
    private String direccion;
    @Column(name = "fecha_nacimiento")
    private LocalDateTime fechaNacimiento;

    public Persona() {
    }
    public Persona(Integer idPersona, String nombre, String correo, String contrasena, String telefono, String direccion, LocalDateTime fechaNacimiento) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
