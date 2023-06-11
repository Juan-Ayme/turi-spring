package com.turi.turispring.propietario.controller;

import com.turi.turispring.propietario.component.PropietarioComponent;
import com.turi.turispring.propietario.entity.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/propietario")
public class PropietarioLoginController
{
    @Autowired
    private PropietarioComponent propietarioComponent;

    @GetMapping("/inicio")
    public String inicio()
    {
        return "/propietariofront/login-propietario";
    }

    @PostMapping("/iniciar")
    public String iniciar(@RequestParam("ruc") String ruc, @RequestParam("contrasena") String contrasena, Model model)
    {
        Propietario propietario = propietarioComponent.login(ruc, contrasena);
        if(propietario != null)
        {
            model.addAttribute("propietario",propietario);
            return "/propietariofront/bienvenido-propietario";
        }
        else
        {
            return "redirect:/propietario/inicio";
        }
    }
}
