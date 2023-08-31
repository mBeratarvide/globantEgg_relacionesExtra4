import entidades.Alumno;
import servicio.Simulador;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Simulador s = new Simulador();
        ArrayList<Alumno> alumnos = s.generarAlumnosDummy(33);
        s.mostrarAlumnos(alumnos);
        s.votacion(alumnos, 3);
        s.mostrarVotacion();
        s.recuento(alumnos);
        // los alumnos no tienen una propiedad facilitador... :S
        
    }
}
