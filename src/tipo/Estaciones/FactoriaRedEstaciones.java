package tipo.Estaciones;

import java.util.List;

import tipo.Auxiliar.Auxiliar;

public class FactoriaRedEstaciones {
	public static RedEstaciones leerRedEstaciones(String nombreFichero) {
		List<String> Lista= Auxiliar.leeFichero(nombreFichero);
		RedEstaciones result= new RedEstaciones();
		for (String e: Lista.subList(1, Lista.size())) {
			result.añadirEstacion(parsearEstacion(e));
		}
		return result;
	}
	
	public static Estacion parsearEstacion(String lineaCSV) {
		return new Estacion(lineaCSV);
	}
	
}
