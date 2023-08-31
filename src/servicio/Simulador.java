package servicio;

import db.Nombres;
import entidades.Alumno;
import entidades.Voto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

public class Simulador {
    private Random rnd = new Random();
    private HashSet<Integer> dus = new HashSet<>();
    private ArrayList<Voto> votos = new ArrayList<>();
    private final int nroFacilitadores = 5;

    public ArrayList<Alumno> generarAlumnosDummy(int cantidadAlumnos) {
        // primero hay que generar los DUs
        generadorDUs(cantidadAlumnos);
        // después hay que generar el listado de alumnos
        ArrayList<Alumno> alumnos = generarListadoAlumnos(cantidadAlumnos);
        // devolver esa wea
        return alumnos;
    }

    public void votacion(ArrayList<Alumno> alumnos, int votosPorAlumno) {
        for(Alumno a : alumnos) {
            ArrayList<Alumno> candidatos = new ArrayList<>(alumnos);
            candidatos.remove(a);
            Voto v = new Voto();
            v.setAlumnoVotante(a);
            ArrayList<Alumno> elegidos = new ArrayList<>();
            for(int j = 0; j < votosPorAlumno; j++) {
                // genero una posición random
                int index = rnd.nextInt(candidatos.size());
                // voto a ese
                elegidos.add(candidatos.get(index));
                alumnos.get(alumnos.indexOf(candidatos.get(index))).upVote(); // +1
                // lo quito de los candidatos
                candidatos.remove(index);
            }
            v.setVotos(elegidos);
            votos.add(v);
        }
    }

    private ArrayList<Alumno> generarListadoAlumnos(int cantidad) {
        ArrayList<Alumno> alumnos = new ArrayList<>();

        int idNombre, idApellido;
        String nombreCompleto;

        for(Integer du : dus) {
            idNombre = rnd.nextInt(Nombres.getNombres().length);
            idApellido = rnd.nextInt(Nombres.getApellidos().length);
            nombreCompleto = Nombres.getNombres()[idNombre] + " " + Nombres.getApellidos()[idApellido];
            alumnos.add(new Alumno(du, nombreCompleto));
        }

        return alumnos;
    }

    private void generadorDUs(int cantidad) {
        do {
            dus.add(rnd.nextInt(10000000)+33000000);
        } while(dus.size() < cantidad);
    }

    public void mostrarAlumnos(ArrayList<Alumno> alumnos) {
        // defino un comparador basado en el valor int (du)
        Comparator<Alumno> comparador = Comparator.comparingInt(Alumno::getDu);

        // ordeno la lista usando el comparador
        alumnos.sort(comparador);

        // imprimo la lista ordenada
        System.out.println("=== Listado de alumnos ===");
        for (Alumno alumno : alumnos) {
            System.out.println("DU: " + alumno.getDu() + ", nombre: " + alumno.getNombre() + ", pulsos: " + alumno.getCantidadVotos());
        }
        firmar();
    }

    public void mostrarVotacion() {
        System.out.println("=== Listado de votos ===");
        for (Voto v : votos) {
            //System.out.println(v);
            System.out.println(v.getAlumnoVotante().getNombre() + " votó a " + v.getVotos());
        }
        firmar();
    }

    public void recuento(ArrayList<Alumno> alumnos) {
        // defino un comparador basado en el valor int (votos)
        Comparator<Alumno> comparador = Comparator.comparingInt(Alumno::getCantidadVotos).reversed();

        // ordeno la lista usando el comparador
        alumnos.sort(comparador);

        // imprimo la lista ordenada
        System.out.println("=== Listado de alumnos x votos recibidos ===");
        int contador = 0;
        for (Alumno a : alumnos) {
            if(contador == 0) {
                System.out.println("Facilitadores titulares");
            } else if(contador == nroFacilitadores) {
                System.out.println("Facilitadores suplentes");
            } else if(contador == nroFacilitadores * 2) {
                System.out.println("Los demas...");
            }
            System.out.println("DU: " + a.getDu() + ", nombre: " + a.getNombre() + ", pulsos: " + a.getCantidadVotos());
            contador++;
        }
        firmar();
    }

    private void firmar() {
        System.out.println("===huevo=school==");
    }

}
