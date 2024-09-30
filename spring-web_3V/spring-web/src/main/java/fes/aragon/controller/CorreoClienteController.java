package fes.aragon.controller;

import fes.aragon.model.Persona;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "correos")
@SessionAttributes("lista")
public class CorreoClienteController {
    //@Autowired
    //private PersonaService personaService;
    @GetMapping("agregar-correo")
    public String vistaCorreoCliente(Model model){
        model.addAttribute("persona",new Persona());
        //model.addAttribute("lista", personaService.getLista());
        return "paginas/clientes/correos-clientes";
    }
    @PostMapping("ingresar-persona")
    public String datosPersona(@Valid @ModelAttribute("persona") Persona persona,
                               BindingResult result, Model model, HttpSession sesion){
        if(result.hasErrors()){
            return "paginas/clientes/correos-clientes";
        }
        List<Persona> lista= (List<Persona>) sesion.getAttribute("lista");
        //personaService.agregarPersona(persona);
        //sesion.invalidate();
        lista.add(persona);
        System.out.println(lista.size());
        return "paginas/clientes/correos-clientes";
        //return "redirect:/correos/agregar-correo";
    }

    @GetMapping("almacenar-persona")
    public String datosPersona(Model model){
        System.out.println("Almacenar en la B.D");
        //personaService.getLista().clear();
        return "redirect:/principal";
    }
}
