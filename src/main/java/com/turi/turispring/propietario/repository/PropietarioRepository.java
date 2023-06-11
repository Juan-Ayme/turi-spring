package com.turi.turispring.propietario.repository;

import com.turi.turispring.propietario.entity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropietarioRepository extends JpaRepository<Propietario,Integer>
{
    Optional<Propietario> findByRuc(String ruc);
}
