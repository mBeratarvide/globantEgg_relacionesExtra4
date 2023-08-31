package entidades;

import java.util.Objects;

public class Alumno {

    private int du;
    private String nombre;
    private int cantidadVotos;

    public Alumno() {}

    public Alumno(int du, String nombre) {
        this.du = du;
        this.nombre = nombre;
        cantidadVotos = 0;
    }

    public int getDu() {
        return du;
    }

    public void setDu(int du) {
        this.du = du;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void upVote() {
        this.cantidadVotos++;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "DU = " + du +
                ", nombre completo = '" + nombre + "'" +
                ", cantidadVotos = " + cantidadVotos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return du == alumno.du && Objects.equals(nombre, alumno.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(du, nombre);
    }

}
