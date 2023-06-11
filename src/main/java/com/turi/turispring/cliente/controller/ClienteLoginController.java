package com.turi.turispring.cliente.controller;

import com.turi.turispring.cliente.component.ClienteComponent;
import com.turi.turispring.cliente.entity.Cliente;
import com.turi.turispring.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cliente")
public class ClienteLoginController
{
    @Autowired
    private ClienteComponent clienteComponent;
    @Autowired
    private ClienteService clienteService;
    //funcion es para ingresar a la pagina login-cliente.html
    @GetMapping("/inicio")
    public String inicio()
    {
        return "/clientefront/login-cliente";
    }

    //funcion sucede cuando se presiona el boton de iniciar sesion de la vista login-cliente.html
    @PostMapping("/iniciar")
    public String iniciar(@RequestParam("tipoIdentificacion") Integer tipo, @RequestParam("contrasena") String contrasena, Model model)
    {
        Cliente cliente = clienteComponent.login(tipo, contrasena);
        if(cliente != null)
        {
            model.addAttribute("clientes",cliente);
            return "/clientefront/bienvenido-cliente";
        }
        else
        {
            return "redirect:/cliente/inicio"; //redirecciona a la vista de inicio
        }
    }
    @GetMapping("/bienvenido")
    public String bienvenido()
    {
        return
                 <
    }
}
