package innova4b.empresaReparto.incidencia.web;

import static org.hamcrest.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import innova4b.empresaReparto.incidencia.domain.Incidencia;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@WebAppConfiguration
public class IncidenciaControllerIntegrationTest {
	
    @Autowired
    private WebApplicationContext wac;
 
    private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void list_envia_una_lista_de_incidencias_a_la_vista() throws Exception {
		this.mockMvc.perform(get("/incidencia/list/1"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("incidencias", any(List.class)));
	}
	
	@Test
	public void new_envia_una_incidencia_nueva_a_la_vista() throws Exception {
		this.mockMvc.perform(get("/incidencia/show/1"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("incidencia", any(Incidencia.class)));
	}
}