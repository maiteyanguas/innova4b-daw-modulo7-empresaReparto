package innova4b.empresaReparto.coche.autocompletar_marcas;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MarcasCoches {

	private String data;
	private ArrayList<String> marcas;

	public MarcasCoches() {

		data = "Audi, BMW, Chevrolet, Chrysler, "
				+ "Citroen, Dacia, Fiat, Ford, Honda, Hyundai, Jaguar,"
				+ " Jeep, Kia, Lancia, Land Rover, Mazda, Mercedes-Benz,"
				+ " Mini, Nissan, Peugeot, Renault, Seat, Skoda, Toyota,"
				+ " Volkswaven, Volvo";

		marcas = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(data, ",");

		while (st.hasMoreTokens()) {

			marcas.add(st.nextToken().trim());
		}

	}

	public List<String> getMarcasEncontradas(String query) {

		query = query.toLowerCase();

		List<String> marcas_encontradas = new ArrayList<String>();

		for (String marca : marcas) {
			if (marca.toLowerCase().startsWith(query)) {
				marcas_encontradas.add(marca);
			}
		}

		return marcas_encontradas;
	}

}
