package com.turi.turispring.cliente.controller;

import com.turi.turispring.cliente.component.ClienteComponent;
import com.turi.turispring.cliente.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteInicioController
{
    @Autowired
    private ClienteComponent clienteComponent;

    @GetMapping("/bienvenido/{id}")
    public String inicio(@PathVariable int id, Model model)
    {
        Cliente cliente = clienteComponent.getId(id).orElse(null);
        model.addAttribute("clientes",cliente);
        return "/clientefront/bienvenido-cliente";
    }

    @PostMapping("/bienvenido2")
    public String bienvenido2(@RequestParam("id") int id, Model model)
    {
        Cliente cliente = clienteComponent.getId(id).orElse(null);
        if (cliente == null) {

            return "redirect:/cliente/inicio";
        }
        model.addAttribute("clientes",cliente);
        return "/clientefront/bienvenido-cliente";
    }

}
