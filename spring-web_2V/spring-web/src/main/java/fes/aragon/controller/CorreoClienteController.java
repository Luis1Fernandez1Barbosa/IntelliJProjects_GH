package fes.aragon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "correos")
public class CorreoClienteController {
    @GetMapping("agregar-correo")
    public String vistaCorreoCliente(){
        return "paginas/clientes/correos-clientes";
    }
}
