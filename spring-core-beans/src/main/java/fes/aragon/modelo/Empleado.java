package fes.aragon.modelo;

public class Empleado {
    private String nombre;
    private Actividades actividad;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(Actividades actividad) {
        this.actividad = actividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Actividades getActividad() {
        return actividad;
    }

    public void setActividad(Actividades actividad) {
        this.actividad = actividad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", actividad=" + actividad +
                '}';
    }
}
