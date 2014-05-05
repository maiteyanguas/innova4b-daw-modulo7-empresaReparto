package innova4b.empresaReparto.coche.domain;

import static org.junit.Assert.*;
import innova4b.empresaReparto.incidencia.domain.Incidencia;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CocheTest {
	
	Coche coche;

	@Before
	public void setUp() throws Exception {
		coche = new Coche();
	}

	private List<Incidencia> buildIncidencias(String descripcion1, boolean resolucion1, String descripcion2, boolean resolucion2) {
		List<Incidencia> incidencias = new ArrayList<Incidencia>();
		Incidencia incidencia = new Incidencia();
		incidencia.setDescripcion(descripcion1);
		incidencia.setResuelta(resolucion1);
		incidencias.add(incidencia);
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setDescripcion(descripcion2);
		incidencia2.setResuelta(resolucion2);
		incidencias.add(incidencia2);
		return incidencias;
	}

	@Test
	public void getIncidenciasPendientes_es_false_si_el_coche_no_tiene_incidencias() {
		assertFalse(coche.getIncidenciasPendientes());
	}
	
	@Test
	public void getIncidenciasPendientes_es_false_si_el_coche_tiene_todas_las_incidencias_resueltas() {
		coche.setIncidencias(buildIncidencias("incidencia",true,"incidencia2",true));
		assertFalse(coche.getIncidenciasPendientes());
	}
	
	@Test
	public void getIncidenciasPendientes_es_true_si_el_coche_tiene_alguna_incidencia_sin_resolver() {
		coche.setIncidencias(buildIncidencias("incidencia",true,"incidencia2",false));
		assertTrue(coche.getIncidenciasPendientes());
	}


}
