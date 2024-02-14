package ar.edu.utn.frbb.tup;


import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.exception.AlumnoNoEncontradoException;
import ar.edu.utn.frbb.tup.persistence.AlumnoDao;
import ar.edu.utn.frbb.tup.persistence.CarreraDao;
import ar.edu.utn.frbb.tup.persistence.MateriaDao;
import ar.edu.utn.frbb.tup.persistence.ProfesorDao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;


@Getter @Setter
@SpringBootApplication
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

    }

    @Component
    class DataLoader implements CommandLineRunner {

        private final MateriaDao materiaDao;
        private final ProfesorDao profesorDao;
        private final AlumnoDao alumnoDao;
        private final CarreraDao carreraDao;

        @Autowired
        public DataLoader(MateriaDao materiaDao, ProfesorDao profesorDao, AlumnoDao alumnoDao, CarreraDao carreraDao) {
            this.materiaDao = materiaDao;
            this.profesorDao = profesorDao;
            this.alumnoDao = alumnoDao;
            this.carreraDao = carreraDao;
        }

        @Override
        public void run(String... args) throws Exception {
            List<Materia> materias = inicializarMaterias();
            List<Profesor> profesores = inicializarProfesores();
            try {
                inicializarAlumnos();
            } catch (AlumnoNoEncontradoException e) {
                throw new RuntimeException(e);
            }
            inicializarCarreras(materias.get(0), materias.get(1), materias.get(2), materias.get(3), profesores.get(0), profesores.get(1), profesores.get(2));
        }

        public List<Materia> inicializarMaterias() {
            List<Materia> materias = List.of(
                    new Materia("Matemáticas", 1, 1, List.of(2, 3), 1, null),
                    new Materia("Física", 1, 2, List.of(1), 1, null),
                    new Materia("Programación", 2, 1, List.of(4), 1, null),
                    new Materia("Base de Datos", 2, 2, List.of(3), 1, null)
            );

            materiaDao.saveAll(materias); // Utilizar el método saveAll para guardar todas las materias

            return materias; // Retornar la lista de materias guardadas
        }

        public List<Profesor> inicializarProfesores() {
            List<Profesor> profesores = List.of(
                    new Profesor("Juan", "Perez", "Licenciado en Informática"),
                    new Profesor("Ana", "Gomez", "Ingeniero en Sistemas"),
                    new Profesor("Carlos", "Lopez", "Doctor en Ciencias de la Computación")
            );

            return profesorDao.saveAll(profesores);
        }

        public void inicializarAlumnos() throws AlumnoNoEncontradoException {
            Alumno alumno1 = new Alumno("Elo", "Cacoco", 123456);
            Alumno alumno2 = new Alumno("Marisa", "Perez", 789012);
            alumnoDao.saveAlumno(alumno1);
            alumnoDao.saveAlumno(alumno2);
        }

        public void inicializarCarreras(Materia materia1, Materia materia2, Materia materia3, Materia materia4, Profesor profesor1, Profesor profesor2, Profesor profesor3) {
            Carrera carrera1 = new Carrera("Ingeniería en Informática", 5,
                    List.of(materia1, materia2, materia3, materia4),
                    List.of(profesor1, profesor2));

            Carrera carrera2 = new Carrera("LOI", 4,
                    List.of(materia1),
                    List.of(profesor3));

            carreraDao.saveCarrera(carrera1);
            carreraDao.saveCarrera(carrera2);
        }
    }
   /* public static void inicializarDatos() {
        List<Materia> materias = inicializarMaterias();
        List<Profesor> profesores = inicializarProfesores();
        inicializarAlumnos(AlumnoDao);
        inicializarCarreras(CarreraDao ,materias.get(0), materias.get(1), materias.get(2), materias.get(3), profesores.get(0), profesores.get(1), profesores.get(2));
    }

    public static List<Materia> inicializarMaterias() {
        Materia materia1 = new Materia("Matemáticas", 1, 1, List.of(2, 3), 1,  null);
        Materia materia2 = new Materia("Física", 1, 2, List.of(1), 1,  null);
        Materia materia3 = new Materia("Programación", 2, 1, List.of(4), 1, null);
        Materia materia4 = new Materia("Base de Datos", 2, 2, List.of(3), 1,  null);

        return List.of(materia1, materia2, materia3, materia4);
    }

    public static List<Profesor> inicializarProfesores() {
        Profesor profesor1 = new Profesor("Juan", "Perez", "Licenciado en Informática");
        Profesor profesor2 = new Profesor("Ana", "Gomez", "Ingeniero en Sistemas");
        Profesor profesor3 = new Profesor("Carlos", "Lopez", "Doctor en Ciencias de la Computación");

        return List.of(profesor1, profesor2, profesor3);
    }

    public static void inicializarAlumnos() {
        Alumno alumno1 = new Alumno("Elo", "Cacoco", 123456);
        Alumno alumno2 = new Alumno("Otro", "Alumno", 789012);
    }

    public static List<Carrera> inicializarCarreras(Materia materia1, Materia materia2, Materia materia3, Materia materia4, Profesor profesor1, Profesor profesor2, Profesor profesor3) {
        Carrera carrera1 = new Carrera("Ingeniería en Informática", 5,
                List.of(materia1, materia2, materia3, materia4),
                List.of(profesor1, profesor2));

        Carrera carrera2 = new Carrera("LOI", 4,
                List.of(materia1),
                List.of(profesor3));

        return List.of(carrera1, carrera2);
    }

       /* Materia materia1 = new Materia("Matemáticas", 1, 1, List.of(2, 3), 1);
        Materia materia2 = new Materia("Física", 1, 2, List.of(1), 1);
        Materia materia3 = new Materia("Programación", 2, 1, List.of(4), 1);
        Materia materia4 = new Materia("Base de Datos", 2, 2, List.of(3), 1);

        // Crear instancias de Asignatura
        Asignatura asignatura1 = new Asignatura("Álgebra", 90, materia1);
        Asignatura asignatura2 = new Asignatura("Cálculo", 75, materia3);
        Asignatura asignatura3 = new Asignatura("Mecánica", 60, materia2);
        Asignatura asignatura4 = new Asignatura("Java Programming", 120, materia3);
        Asignatura asignatura5 = new Asignatura("SQL", 90, materia4);

        // Asignar correlativas a las materias
        materia1.setCorrelativas(List.of(2, 3));
        materia2.setCorrelativas(List.of(1));
        materia3.setCorrelativas(List.of(2));
        materia4.setCorrelativas(List.of(3));

        Profesor profesor1 = new Profesor("Juan", "Perez", "Licenciado en Informática");
        Profesor profesor2 = new Profesor("Ana", "Gomez", "Ingeniero en Sistemas");
        Profesor profesor3 = new Profesor("Carlos", "Lopez", "Doctor en Ciencias de la Computación");

        // Inicializar la lista de materiasDictadas para cada profesor
        profesor1.setMateriasDictadas(new ArrayList<>());
        profesor2.setMateriasDictadas(new ArrayList<>());
        profesor3.setMateriasDictadas(new ArrayList<>());

        // Asignar materias dictadas a los profesores después de inicializar las listas
        profesor1.agregarMateriaDictada(materia1);
        profesor1.agregarMateriaDictada(materia2);
        profesor2.agregarMateriaDictada(materia3);
        profesor3.agregarMateriaDictada(materia4);

        // Crear instancias de Carrera y agregar las materias y profesores
        Carrera carrera1 = new Carrera("Ingeniería en Informática", 5,
                List.of(materia1, materia2, materia3, materia4),
                List.of(profesor1, profesor2));

        Carrera carrera2 = new Carrera("LOI", 4,
                List.of(materia1),
                List.of(profesor3));

        // Crear instancias de Alumno y agregar asignaturas
        Alumno alumno1 = new Alumno("Elo", "Cacoco", 123456);
        alumno1.agregarAsignatura(asignatura1);
        alumno1.agregarAsignatura(asignatura2);
        alumno1.agregarAsignatura(asignatura3);

        Alumno alumno2 = new Alumno("Otro", "Alumno", 789012);
        alumno2.agregarAsignatura(asignatura4);
        alumno2.agregarAsignatura(asignatura5);
    }*/
}

