package com.turi.turispring.cliente.repository;

import com.turi.turispring.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>
{
    Optional<Cliente> findByTipoIdentificacion(Integer tipoIdentificacion);
}
