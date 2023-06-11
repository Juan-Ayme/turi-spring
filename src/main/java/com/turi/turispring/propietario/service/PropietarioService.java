package com.turi.turispring.propietario.service;

import com.turi.turispring.hotel.entity.Hotel;
import com.turi.turispring.hotel.repository.HotelRepository;
import com.turi.turispring.propietario.component.PropietarioComponent;
import com.turi.turispring.propietario.entity.Propietario;
import com.turi.turispring.propietario.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioService implements PropietarioComponent
{
    private final PropietarioRepository propietarioRepository;
    private final HotelRepository hotelRepository;

    public PropietarioService(PropietarioRepository propietarioRepository, HotelRepository hotelRepository) {
        this.propietarioRepository = propietarioRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Propietario> getPropietarios()
    {
        return propietarioRepository.findAll();
    }

    @Override
    public Propietario getPropietarioById(Integer propietarioId)
    {
        return propietarioRepository.findById(propietarioId).orElse(null);
    }

    @Override
    public void savePropietario(Propietario propietario)
    {
        propietarioRepository.save(propietario);
    }

    @Override
    public void updatePropietario(Propietario propietario)
    {
        propietarioRepository.save(propietario);
    }

    @Override
    public void deletePropietarioById(Integer propietarioId)
    {
        propietarioRepository.deleteById(propietarioId);
    }

    @Override
    public Propietario login(String ruc, String contrasena)
    {
        Propietario propietario =propietarioRepository.findByRuc(ruc).orElse(null);

        if (propietario!=null)
        {
            if(propietario.getPersona().getContrasena().equals(contrasena))
            {
                return propietario;
            }
        }
        return null;
    }

}
