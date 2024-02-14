/*package ar.edu.utn.frbb.tup.model;
import ar.edu.utn.frbb.tup.business.AsignaturaService;
import ar.edu.utn.frbb.tup.business.impl.AsignaturaNoAprobadaException;
import ar.edu.utn.frbb.tup.business.impl.AsignaturaServiceImpl;
import ar.edu.utn.frbb.tup.model.exception.AlumnoNoEncontradoException;
import ar.edu.utn.frbb.tup.model.exception.AsignaturaInexistenteException;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadException;
import ar.edu.utn.frbb.tup.persistence.AlumnoDao;
import ar.edu.utn.frbb.tup.persistence.MateriaDao;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
/*@ExtendWith(MockitoExtension.class)

public class AsignaturaServiceImplTest {

    @Mock
    private AlumnoDao alumnoDao;

    @Mock
    private MateriaDao materiaDao;

    @InjectMocks
    private AsignaturaService asignaturaService = new AsignaturaServiceImpl();

    private Materia materia;
    private Asignatura asignatura;

    @BeforeEach
    public void setUp() {
        materia = new Materia("Laboratorio 3", 2, 1, null);
        asignatura = new Asignatura( );
    }

    @Test
    public void testGetAsignaturaAAprobar() throws AsignaturaInexistenteException {
        when(asignaturaService.getAsignaturaAAprobar(materia)).thenReturn(asignatura);

        assertEquals(asignatura, asignaturaService.getAsignaturaAAprobar(materia));
    }
    @Test
    public void testChequearCorrelatividad_AsignaturaNoAprobada() throws AlumnoNoEncontradoException {
        // Configuración del alumno con asignaturas no aprobadas
        Alumno alumno = new Alumno();
        Asignatura asignaturaNoAprobada = new Asignatura();
        asignaturaNoAprobada.setEstado(EstadoAsignatura.NO_CURSADA);
        // Agrega la asignatura no aprobada al alumno
        alumno.agregarAsignatura(asignaturaNoAprobada);

        // Configuración del mock para el alumno
        AlumnoDao alumnoDao = Mockito.mock(AlumnoDao.class);
        when(alumnoDao.loadAlumnoPorId(anyInt())).thenReturn(alumno);

        // Creación de la instancia del servicio
        AsignaturaServiceImpl asignaturaService = new AsignaturaServiceImpl();

        // Llamada al método para chequear correlatividad
        Materia materiaCorrelativa = new Materia("Laboratorio 3", 2023, 1,new Profesor("Luciano", "Salotto", "Licenciado") );

        // Verifica si se lanza la excepción adecuada
        assertThrows(CorrelatividadException.class, () -> asignaturaService.chequearCorrelatividad(materiaCorrelativa));
    }


    @Test
    public void testAprobarAsignatura_NoCursada() throws AsignaturaInexistenteException {
        when(asignaturaService.getAsignaturaAAprobar(materia)).thenReturn(asignatura);

        assertThrows(EstadoIncorrectoException.class, () -> asignaturaService.aprobarAsignatura(materia, 8));
    }

    @Test
    public void testActualizarAsignatura_AsignaturaNoAprobada() throws AsignaturaInexistenteException, AlumnoNoEncontradoException {
        Alumno alumno = new Alumno();
        alumno.setAsignaturas(List.of(asignatura));

        when(alumnoDao.loadAlumnoPorId(anyInt())).thenReturn(alumno);

        assertThrows(AsignaturaNoAprobadaException.class, () -> asignaturaService.actualizarAsignatura(asignatura, 123));
    }


    @Test
    public void testCrearAsignatura_AsignaturaCreada() throws AlumnoNoEncontradoException, MateriaNotFoundException {
        Alumno alumno = Mockito.spy(new Alumno());

        // Mock para simular la carga de un alumno por ID
        when(alumnoDao.loadAlumnoPorId(anyInt())).thenReturn(alumno);

        AtomicInteger contadorAlumno = new AtomicInteger(0);

        // Simulamos el método que genera el ID del alumno
        doAnswer(invocation -> {
            alumno.setIdAlumno(contadorAlumno.getAndIncrement());
            return null;
        }).when(alumno).setIdAlumno();

        Materia materia = new Materia("Laboratorio 3", 2, 1, new Profesor("Luciano","Salotto", "Licenciado"));

        // Mock para simular la carga de una materia por ID
        when(materiaDao.loadMateriaById(anyInt())).thenReturn(materia);

        // Simulamos un ID aleatorio para la materia
        when(materia.getMateriaId()).thenReturn(new Random().nextInt(1000));

        asignaturaService.crearAsignatura(1, 1); // Suponiendo IDs de alumno y materia válidos

        assertEquals(1, alumno.getAsignaturas().size());
    }



}*/
