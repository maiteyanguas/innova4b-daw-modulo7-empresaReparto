package innova4b.empresaReparto.coche.web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.empresa.domain.Empresa;

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
public class CocheControllerIntegrationTest {
	
    @Autowired
    private WebApplicationContext wac;
 
    private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void list_envia_una_lista_de_coches_a_la_vista() throws Exception {
		this.mockMvc.perform(get("/coche/listAll"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("coches", any(List.class)));
	}
	
	@Test
	public void new_envia_un_coche_nuevo_a_la_vista() throws Exception {
		this.mockMvc.perform(get("/coche/new"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("coche", any(Coche.class)));
	}
	
}
