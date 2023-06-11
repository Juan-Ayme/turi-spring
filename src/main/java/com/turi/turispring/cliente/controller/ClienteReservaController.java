package com.turi.turispring.cliente.controller;

import com.turi.turispring.cliente.component.ClienteComponent;
import com.turi.turispring.cliente.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteReservaController
{

    @Autowired
    private ClienteComponent clienteComponent;

    //funcion es para ingresar a la pagina login-cliente.html
    @GetMapping("/reserva/{id}")
    public String reserva(@PathVariable int id, Model model)
    {
        Cliente cliente = clienteComponent.getId(id).orElse(null);
        model.addAttribute("clientes",cliente);
        return "/clientefront/cliente-reserva";
    }
}
