package com.turi.turispring.reserva.repository;

import com.turi.turispring.cliente.entity.Cliente;
import com.turi.turispring.reserva.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva,Integer>
{
    List<Reserva> findByCliente(Cliente cliente); // SELECT * FROM reserva WHERE cliente_id = ?
}
