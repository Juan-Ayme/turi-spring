package com.turi.turispring.persona.component;

import com.turi.turispring.persona.entity.Persona;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PersonaComponent
{
    List<Persona> listar();
    Optional<Persona> listarId(int id);
    void save(Persona p);
    void delete(int id);
    Optional<Persona> login(String correo, String contrasena);
}
