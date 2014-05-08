package innova4b.empresaReparto.coche.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import innova4b.empresaReparto.coche.domain.Coche;
import innova4b.empresaReparto.coche.repository.CocheDao;
import innova4b.empresaReparto.empresa.domain.Empresa;
import innova4b.empresaReparto.exceptions.EmpresaWithCochesException;
import innova4b.empresaReparto.exceptions.EmpresaWithEmpleadosException;
import innova4b.empresaReparto.exceptions.JsonUtilException;
import innova4b.empresaReparto.util.JsonUtil;
import innova4b.empresaReparto.util.TypeReferenceDireccionList;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CocheServiceTest {

	CocheService cocheService;

	@Mock
	CocheDao cocheDaoMock;

	@Before
	public void setUp() throws Exception {
		cocheService = new CocheService();
		cocheService.setCocheDao(cocheDaoMock);

	}

	@Test
	public void getCochesFiltrados_filtra_todos_coches_por_empresa()
			throws Exception {

		int idEmpresa = 87;
		cocheService.getCochesFiltrados(cocheService.FILTRO_EMPRESA, idEmpresa,
				cocheService.FILTRO_TODOS_COCHES_POR_EMPRESA, "");

		verify(cocheDaoMock).listWithEmpresa(idEmpresa);

	}

}
