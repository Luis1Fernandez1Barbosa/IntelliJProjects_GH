package fes.aragon.service;

import fes.aragon.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaServicioImpl implements PersonaService{
    private List<Persona> lista=new ArrayList<>();
    @Override
    public void agregarPersona(Persona persona) {
           lista.add(persona);
    }

    @Override
    public List<Persona> getLista() {
        return this.lista;
    }

    @Override
    public void setLista(List<Persona> lista) {
        this.lista=lista;
    }
}
