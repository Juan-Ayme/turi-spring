package com.turi.turispring.persona.service;

import com.turi.turispring.persona.component.PersonaComponent;
import com.turi.turispring.persona.entity.Persona;
import com.turi.turispring.persona.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements PersonaComponent
{
    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public List<Persona> listar()
    {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id)
    {
        return personaRepository.findById(id);
    }

    @Override
    public void save(Persona p)
    {
        Persona persona = personaRepository.save(p);
    }

    @Override
    public void delete(int id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Optional<Persona> login(String correo, String contrasena)
    {
        return personaRepository.findByCorreoAndContrasena(correo, contrasena);
    }
}
