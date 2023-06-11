package com.turi.turispring.hotel.repository;

import com.turi.turispring.hotel.entity.Hotel;
import com.turi.turispring.propietario.entity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Integer>
{
}
