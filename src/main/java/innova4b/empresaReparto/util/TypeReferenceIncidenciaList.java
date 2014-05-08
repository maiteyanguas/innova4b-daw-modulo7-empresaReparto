package innova4b.empresaReparto.util;

import innova4b.empresaReparto.incidencia.domain.Incidencia;

import java.util.List;

import org.codehaus.jackson.type.TypeReference;

public class TypeReferenceIncidenciaList extends TypeReference<List<Incidencia>>{

	private static TypeReferenceIncidenciaList instance = new TypeReferenceIncidenciaList();

	private TypeReferenceIncidenciaList() {}

	public static TypeReferenceIncidenciaList getInstance() {
		return instance;
	}

	
}