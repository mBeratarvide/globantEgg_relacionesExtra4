package entidades;

import java.util.ArrayList;
import java.util.Objects;

public class Voto {

    private Alumno alumnoVotante;
    private ArrayList<Alumno> votos;

    public Voto() {}

    public Voto(Alumno av, ArrayList<Alumno> v) {
        alumnoVotante = av;
        votos = v;
    }

    public Alumno getAlumnoVotante() {
        return alumnoVotante;
    }

    public void setAlumnoVotante(Alumno alumnoVotante) {
        this.alumnoVotante = alumnoVotante;
    }

    public ArrayList<Alumno> getVotos() {
        return votos;
    }

    public void setVotos(ArrayList<Alumno> votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return alumnoVotante.getNombre() +
                " votó a " + votos +
                '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return Objects.equals(alumnoVotante, voto.alumnoVotante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alumnoVotante);
    }

}
