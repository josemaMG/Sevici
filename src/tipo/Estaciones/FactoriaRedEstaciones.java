package tipo.Estaciones;

import tipo.Auxiliar.Auxiliar;

public class FactoriaRedEstaciones {
	public static RedEstaciones leerRedEstaciones(String nombreFichero) {
		RedEstaciones result= new RedEstaciones();
		for (String e: Auxiliar.leeFichero(nombreFichero)) {
			result.añadirEstacion(parsearEstacion(e));
		}
		return result;
	}
	
	public static Estacion parsearEstacion(String lineaCSV) {
		return new Estacion(lineaCSV);
	}
	
}
