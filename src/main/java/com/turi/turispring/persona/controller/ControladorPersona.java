package com.turi.turispring.persona.controller;

import com.turi.turispring.persona.component.PersonaComponent;
import com.turi.turispring.persona.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/persona")
public class ControladorPersona
{
    @Autowired
    private PersonaComponent personaComponent;

    @GetMapping("/listar")
    public String listar(Model model)
    {
        List<Persona> personas = personaComponent.listar();
        model.addAttribute("personas",personas);//personas es el nombre de la variable que se va a usar en la vista
        return "indexpersona2";
    }

    @GetMapping("/new")
    public String agregar(Model model)
    {
        model.addAttribute("persona",new Persona());//persona es el nombre de la variable que se va a usar en la vista
        return "formulario";
    }

    @PostMapping("/save")
    public String save(@Validated Persona p, Model model)
    {
        personaComponent.save(p);
        return "redirect:/persona/listar";//redirecciona a la ruta listar
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable int id, Model model)
    {
        Optional<Persona> persona = personaComponent.listarId(id);
        model.addAttribute("persona",persona);
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable int id, Model model)
    {
        personaComponent.delete(id);
        return "redirect:/persona/listar";
    }

    @PostMapping("/login")
    public String login(@RequestParam("correo") String correo, @RequestParam("contrasena") String contrasena, Model model)
    {
        Optional<Persona> persona = personaComponent.login(correo, contrasena);
        if (persona.isPresent()) {
            model.addAttribute("persona", persona.get());//persona es el nombre de la variable que se va a usar en la vista
            return "inicio"; // Nombre de la vista para mostrar después del inicio de sesión exitoso
        } else {
            return "redirect:/persona/logincliente"; // Nombre de la vista del formulario de inicio de sesión
        }
    }
    @GetMapping("/iniciar")
    public String iniciar()
    {
        return "logincliente";
    }
}
