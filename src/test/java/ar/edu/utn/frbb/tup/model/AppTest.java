package ar.edu.utn.frbb.tup.model;
/*package ar.edu.utn.frbb.tup.model;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlumnoTest {

    private static Alumno alumno;
    private static Materia m1;
    private static Materia m2;
    private static Materia m3;
    private static Materia m4;
    private static Profesor profesor1;
    private static Asignatura a1;
    private static Asignatura a2;
    private static Asignatura a3;
    private static Asignatura a4;

    private void assertThrows(Class<AsignaturaExistenteException> asignaturaExistenteExceptionClass, Object o) {
    }

    @BeforeAll
    public static void setUp() {

        profesor1 = new Profesor("Luciano", "Salotto", "Lic.");
        m1 = new Materia("Laboratorio 1", 1, 1, profesor1);
        m2 = new Materia("Laboratorio 2", 1, 2, profesor1);
        m3 = new Materia("Laboratorio 3", 2, 1, profesor1);
        m4 = new Materia("Laboratorio 4", 2, 2, profesor1);
        m2.agregarCorrelatividad(m1);
        m3.agregarCorrelatividad(m1);
        m3.agregarCorrelatividad(m2);
        m4.agregarCorrelatividad(m1);
        m4.agregarCorrelatividad(m2);
        m4.agregarCorrelatividad(m3);
        a1 = new Asignatura();
        a2 = new Asignatura();
        a3 = new Asignatura();
        a4 = new Asignatura();

    }

    @Test
    public void testNewAlumno() {
        alumno = new Alumno();
        assertEquals("Emilce", alumno.getNombre());
        assertEquals("Caba", alumno.getApellido());
        assertEquals(20392980, alumno.getDniAlumno());

    }

    @Test
    public void testAgregarAsignaturaAlumno() {
        alumno = new Alumno();
        alumno.agregarAsignatura(a1);
        alumno.agregarAsignatura(a2);
        assertEquals(2, alumno.obtenerListaAsignaturas().size());
    }

    @Test
    public void testModificarDatosAlumno() {
        alumno = new Alumno();
        alumno.setNombre("Juan");
        alumno.setApellido("Perez");
        assertEquals("Juan", alumno.getNombre());
        assertEquals("Perez", alumno.getApellido());
    }

    @Test
    public void testEqualsAlumnos() {
        Alumno alumno1 = new Alumno();
        Alumno alumno2 = new Alumno();
        assertEquals(alumno1, alumno2);
    }

    @Test
    public void testGenerarIdAlumnoAutomaticamente() {
        Alumno alumno1 = new Alumno();
        Alumno alumno2 = new Alumno();
        assertNotEquals(alumno1.getIdAlumno(), alumno2.getIdAlumno());
    }


    @Test
    public void testAgregarAsignaturaExistente() {
        Alumno alumno = new Alumno();
        Asignatura asignatura = new Asignatura();

        // Agregar una asignatura por primera vez
        alumno.agregarAsignatura(asignatura);

        boolean exceptionThrown = false;
        // Intentar agregar la misma asignatura nuevamente
        alumno.agregarAsignatura(asignatura);

        // Verificar si se lanzó la excepción esperada
        assertTrue(exceptionThrown, "Se esperaba una AsignaturaExistenteException al agregar la misma asignatura dos veces");
    }

    @Test
    public void testModificarDatosAlumnoInvalidos() {
        Alumno alumno = new Alumno();

        // Intentar establecer un nombre nulo
        try {
            alumno.setNombre(null);
            fail("Debería haber lanzado una IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // La excepción fue capturada correctamente
        }

        // Intentar establecer un apellido vacío
        try {
            alumno.setApellido("");
            fail("Debería haber lanzado una IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // La excepción fue capturada correctamente
        }
    }

    @Test
    public void testEqualsAlumnosDistintos() {
        Alumno alumno1 = new Alumno();
        Alumno alumno2 = new Alumno();

        alumno2.setNombre("Juan");

        assertNotEquals(alumno1, alumno2);
    }
}
import ar.edu.utn.frbb.tup.App;
import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.business.impl.AlumnoServiceImpl;
import ar.edu.utn.frbb.tup.model.*;
import ar.edu.utn.frbb.tup.model.exception.AlumnoNoEncontradoException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    AlumnoServiceImpl alumnoServiceImplement;
    Materia materia;

    Profesor profesor;
    Carrera carrera;
    Alumno alumno;
    private App app;

    @Before
    public void inicializarApp() {
        app = new App();
    }
    @Test
    public void testInicializarDatos() {
        App app = new App();
        alumnoServiceImplement = new AlumnoServiceImpl();
        carrera = new Carrera(materias, profesores);
        List<Materia> materias = app.inicializarMaterias();
        List<Profesor> profesores = app.inicializarProfesores();

        // Inicializar datos
        app.inicializarDatos();


        // Obtener los objetos creados
       app.inicializarMaterias();
       app.inicializarProfesores();
        app. inicializarAlumnos();
      app.inicializarCarreras(materias,profesores);

        assertNotNull(materia);
        assertNotNull(profesor);
        assertNotNull(carrera);
        assertNotNull(alumno);


        // Verificar que se hayan creado los objetos esperados
        assertEquals(4, materia.getIdMateria());
        assertEquals(3, profesor.getIdProfesor());
        assertEquals(2, carrera.getIdCarrera());
        assertEquals(2, alumno.getIdAlumno ());
    }

    @Test
    public void testAsignaturasParaAlumnos() throws AlumnoNoEncontradoException {
        App app = new App();
        AlumnoService alumnoService = new AlumnoServiceImpl();
        // Inicializar datos
        app.inicializarDatos();

        // Verificar que los alumnos tengan las asignaturas esperadas
        Alumno alumno1 = alumnoServiceImplement.buscarAlumnoPorId(1);
        assertNotNull(alumno1);
        assertEquals(3, alumno1.getAsignaturas().size());

        Alumno alumno2 = alumnoServiceImplement.buscarAlumnoPorId(2);
        assertNotNull(alumno2);
        assertEquals(2, alumno2.getAsignaturas().size());
    }

    // Agrega más pruebas según sea necesario

}*/









