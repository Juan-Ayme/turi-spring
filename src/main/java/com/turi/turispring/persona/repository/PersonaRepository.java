package com.turi.turispring.persona.repository;

import com.turi.turispring.persona.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer>
{
    Optional<Persona> findByCorreoAndContrasena(String correo, String contrasena);
}
