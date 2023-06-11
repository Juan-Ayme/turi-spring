package com.turi.turispring.cliente.controller;

import com.turi.turispring.cliente.component.ClienteComponent;
import com.turi.turispring.cliente.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/cliente")
@RequestMapping("/clie")
public class ClienteController
{
    @Autowired
    private ClienteComponent clienteComponent;

    //listar
    @GetMapping("/listar")
    public String listar(Model model)
    {
        List<Cliente> clientes = clienteComponent.getAll();
        model.addAttribute("clientes",clientes);//personas es el nombre de la variable que se va a usar en la vista
        return "/clientefront/lista-cliente";
    }

    //Guardar Cliente
    @GetMapping("/agregar")
    public String agregar(Model model)
    {
        model.addAttribute("cliente",new Cliente());//persona es el nombre de la variable que se va a usar en la vista
        return "/clientefront/nuevocliente";
    }

    @PostMapping("/guardar")
    public String agregarCliente(@ModelAttribute("cliente") Cliente cliente) {
        // Aquí puedes realizar la lógica para guardar el nuevo cliente en la base de datos
        clienteComponent.save(cliente);
        return "redirect:/cliente/listar";
    }

    //Editar Cliente
    @GetMapping("/editar/{id}")
    public String edit(@PathVariable int id, Model model)
    {
        Cliente cliente = clienteComponent.getId(id).orElse(null);
        model.addAttribute("cliente",cliente);
        return "/clientefront/nuevocliente";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable int id, Model model)
    {
        clienteComponent.delete(id);
        return "redirect:/cliente/listar";
    }

}
