package fes.aragon.controller;

import fes.aragon.model.Persona;
import fes.aragon.service.PersonaService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "correos")
@SessionAttributes("lista")
public class CorreoClienteController {
    //ya no es necesario el servicio para este ejemplo y queda más claro
    //como no llegamos a ocupar la base de datos no es necesario el servicio
    @GetMapping("agregar-correo")
    public String vistaCorreoCliente(Model model){
        List<Persona> lista=new ArrayList<>();
        model.addAttribute("lista",lista);
        model.addAttribute("persona",new Persona());
        return "paginas/clientes/correos-clientes";
    }
    @PostMapping("ingresar-persona")
    public String datosPersona(@Valid @ModelAttribute("persona") Persona persona,
                               BindingResult result,
                               Model model, HttpSession sesion){
        if(result.hasErrors()){
            return "paginas/clientes/correos-clientes";
        }
        List<Persona> lista=(List<Persona>) sesion.getAttribute("lista");
        lista.add(persona);
        model.addAttribute("persona",new Persona());
        return "paginas/clientes/correos-clientes";
    }
    @GetMapping("almacenar-persona")
    public String datosPersona(SessionStatus status, HttpSession sesion){
        System.out.println("Almacenar en la B.D");
        //se tiene los datos para almacenar a la base de datos
        List<Persona> lista=(List<Persona>) sesion.getAttribute("lista");
        for(Persona persona:lista){
            System.out.println(persona);
        }
        //ya no se es necesario el bean de sesión
        status.isComplete();
        return "redirect:/correos/agregar-correo";
    }

}
