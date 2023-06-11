package com.turi.turispring.propietario.component;

import com.turi.turispring.hotel.entity.Hotel;
import com.turi.turispring.propietario.entity.Propietario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PropietarioComponent
{
    List<Propietario> getPropietarios();
    Propietario getPropietarioById(Integer propietarioId);
    void savePropietario(Propietario propietario);
    void updatePropietario(Propietario propietario);
    void deletePropietarioById(Integer propietarioId);
    Propietario login(String ruc, String contrasena);

}
