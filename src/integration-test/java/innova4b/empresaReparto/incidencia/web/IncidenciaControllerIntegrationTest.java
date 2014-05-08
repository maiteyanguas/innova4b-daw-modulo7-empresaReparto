package innova4b.empresaReparto.incidencia.web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.incidencia.domain.Incidencia;
import innova4b.empresaReparto.reserva.domain.Reserva;

import java.util.List;
import java.util.Map;

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
	public void add_envia_una_incidencia_nueva() throws Exception {
		this.mockMvc.perform(post("/incidencia/add"))
        .andExpect(status().isOk());
	}

}
