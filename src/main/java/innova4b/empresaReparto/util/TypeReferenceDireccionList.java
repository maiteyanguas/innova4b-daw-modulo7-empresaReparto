package innova4b.empresaReparto.util;

import innova4b.empresaReparto.empresa.domain.Direccion;
import java.util.List;

import org.codehaus.jackson.type.TypeReference;

public class TypeReferenceDireccionList extends TypeReference<List<Direccion>> {

	private static TypeReferenceDireccionList instance = new TypeReferenceDireccionList();

	private TypeReferenceDireccionList() {
	}

	public static TypeReferenceDireccionList getInstance() {
		return instance;
	}


}