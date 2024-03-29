package ar.edu.utn.frbb.tup.controller;

import static org.mockito.ArgumentMatchers.any;

/*@ExtendWith(SpringExtension.class)
public class MateriaControllerTest {

    @InjectMocks
    MateriaController materiaController;

    @Mock
    MateriaService materiaService;

    MockMvc mockMvc;

    private static ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(materiaController).build();
    }

    @Test
    public void crearMateriaTest() throws Exception, ProfesorNoEncontradoException {

        Mockito.when(materiaService.crearMateria(any(MateriaDto.class))).thenReturn(new Materia());
        MateriaDto materiaDto = new MateriaDto();
        materiaDto.setAnio(1);
        materiaDto.setCuatrimestre(2);
        materiaDto.setNombre("Laboratorio II");
        materiaDto.setiDProfesor(RandomIDGenerateService.getInstance().generateId(5));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/materia")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(materiaDto))
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andReturn();


        Assertions.assertEquals(new Materia(), mapper.readValue(result.getResponse().getContentAsString(), Materia.class));
    }

    @Test
    public void testCrearMateriaBadRequest() throws Exception, ProfesorNoEncontradoException {

        Mockito.when(materiaService.crearMateria(any(MateriaDto.class))).thenReturn(new Materia());
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/materia")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"nombre\" : \"Laboratorio II\",\n" +
                                "    \"anio\" : \"segundo\", \n" +
                                "    \"cuatrimestre\" : 1,\n" +
                                "    \"profesorId\" : 2 \n" +
                                "}")
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest())
                .andReturn();

    }


*/