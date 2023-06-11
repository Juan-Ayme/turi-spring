package com.turi.turispring.cliente.service;

import com.turi.turispring.cliente.component.ClienteComponent;
import com.turi.turispring.cliente.entity.Cliente;
import com.turi.turispring.cliente.repository.ClienteRepository;
import com.turi.turispring.persona.repository.PersonaRepository;
import com.turi.turispring.reserva.entity.Reserva;
import com.turi.turispring.reserva.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements ClienteComponent {

    private final  ClienteRepository clienteRepository;
    private final ReservaRepository reservaRepository;

    public ClienteService( ClienteRepository clienteRepository, ReservaRepository reservaRepository) {

        this.clienteRepository = clienteRepository;
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<Cliente> getAll()
    {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getId(int id)
    {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente;
    }

    @Override
    public void save(Cliente cliente)
    {
        clienteRepository.save(cliente);
    }

    @Override
    public void delete(int id)
    {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente login(Integer tipoIdentificacion, String contrasena)
    {
        Cliente cliente = clienteRepository.findByTipoIdentificacion(tipoIdentificacion).orElse(null);

       if (cliente!=null)
       {
           if(cliente.getPersona().getContrasena().equals(contrasena))
           {
               return cliente;
           }
       }
        return null;
    }
    public List<Reserva> getReservasByCliente(Cliente cliente) {
        return reservaRepository.findByCliente(cliente);
    }

}
