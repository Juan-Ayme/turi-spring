package com.turi.turispring.cliente.component;

import com.turi.turispring.cliente.entity.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ClienteComponent
{
    List<Cliente> getAll();
    Optional<Cliente> getId(int id);
    void save(Cliente cliente);
    void delete(int id);
    Cliente login(Integer tipoIdentificacion, String contrasena);
}
