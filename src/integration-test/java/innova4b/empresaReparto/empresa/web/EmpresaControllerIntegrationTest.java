package innova4b.empresaReparto.empresa.web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
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
public class EmpresaControllerIntegrationTest {
	
    @Autowired
    private WebApplicationContext wac;
 
    private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void list_envia_una_lista_de_empresas_a_la_vista() throws Exception {
		this.mockMvc.perform(get("/empresa/list"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("empresas", any(List.class)));
	}
	
	@Test
	public void new_envia_una_empresa_nueva_a_la_vista() throws Exception {
		this.mockMvc.perform(get("/empresa/new"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("empresa", any(Empresa.class)));
	}
	
	@Test
	public void edit_envia_la_empresa_a_editar_a_la_vista() throws Exception {
		this.mockMvc.perform(get("/empresa/edit/1"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("empresa", any(Empresa.class)))
        .andExpect(view().name("empresa/edit"));
	}

}
