/*package ar.edu.utn.frbb.tup.model;
    import ar.edu.utn.frbb.tup.business.AsignaturaService;
    import ar.edu.utn.frbb.tup.model.exception.AsignaturaInexistenteException;
    import ar.edu.utn.frbb.tup.model.exception.CorrelatividadException;
    import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertFalse;
    import org.junit.runner.RunWith;
    import org.mockito.Mock;
    import org.mockito.junit.MockitoJUnitRunner;

    import static org.junit.Assert.assertEquals;
    import static org.mockito.Mockito.when;*/


    /*@RunWith(MockitoJUnitRunner.class)
    public class AsignaturaServiceTest {
        private static Asignatura asignatura;
        private static Materia materia;
        private static Profesor profesor;
        @Mock
        private AsignaturaService asignaturaService;


        @BeforeAll
        public static void setUp(){
            profesor = new Profesor("Luciano", "Salotto", "Lic.");
            materia = new Materia("Laboratorio 3", 2, 1, profesor);
            asignatura = new Asignatura("", EstadoAsignatura.CURSADA, 8);
        }
        @Test
        public void testNewAsignatura() {

            assertEquals(EstadoAsignatura.NO_CURSADA, asignatura.getEstado());
            assertFalse(Boolean.parseBoolean(asignatura.getNota().toString()));
            assertEquals("Laboratorio 3", asignatura.getMateriaId());
        }

       @Test
        public void testAprobarAsignatura() throws EstadoIncorrectoException, CorrelatividadException, AsignaturaInexistenteException, AsignaturaInexistenteException {
                // Arrange
                Materia materia = new Materia(materia;
                Asignatura asignaturaMock = new Asignatura(/* datos de prueba */
               /* when(asignaturaService.getAsignaturaAAprobar(materia)).thenReturn(asignaturaMock);
                when(asignaturaService.chequearCorrelatividad(materia)).thenReturn(/* resultado esperado */

                // Act
               /* asignaturaService.aprobarAsignatura(materia, /* nota */

                // Assert
                // Verifica el estado y la nota de la asignatura después de la aprobación
                /*assertEquals(EstadoAsignatura.APROBADA, asignaturaMock.getEstado());
                // Agrega más aserciones según sea necesario
        }



        @Test(expected = EstadoIncorrectoException.class)
        public void testAprobarAsignaturaMateriaNoCursada() throws EstadoIncorrectoException{
            Asignatura asignatura = new Asignatura();
            asignatura.aprobarAAsignatura(8);
        }

        @Test (expected = EstadoIncorrectoException.class)
        public void testAprobarAasignaturaYaAprobada() throws EstadoIncorrectoException{
            Asignatura asignatura = new Asignatura();
            asignatura.cursarAsignatura();
            asignatura.aprobarAasignatura(8);
            assertEquals(EstadoAsignatura.APROBADA,asignatura.getEstado());
            asignatura.aprobarAsignatura(9);

        }

        @Test(expected = IllegalArgumentException.class)
        public void aprobarAsignaturaNotaMenorCero() throws EstadoIncorrectoException {
            Asignatura asignatura = new Asignatura();
            asignatura.cursarAsignatura();
            asignatura.aprobarAsignatura(-3);
        }

        @Test(expected = IllegalArgumentException.class)
        public void aprobarAsignaturaNotaMayorDiez() throws EstadoIncorrectoException {
            Asignatura asignatura = new Asignatura();
            asignatura.cursarAsignatura();
            asignatura.aprobarAsignatura(13);
        }

        @Test
        public void aprobarAsignaturaNotaDesaprobado() throws EstadoIncorrectoException {
            Asignatura asignatura = new Asignatura();
            asignatura.cursarAsignatura();
            asignatura.aprobarAsignatura(3);
            assertEquals(EstadoAsignatura.CURSADA, asignatura.getEstado());
        }

    }*/
