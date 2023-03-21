package tipo.Estaciones;

import java.util.List;

import tipo.Auxiliar.Auxiliar;

public class FactoriaRedEstaciones {
	public static RedEstaciones leerRedEstaciones(String nombreFichero) {
		RedEstaciones result= new RedEstaciones();
		for (String e: List.of(Auxiliar.leeFichero(nombreFichero).remove(0))) {
			result.añadirEstacion(parsearEstacion(e));
		}
		return result;
	}
	
	public static Estacion parsearEstacion(String lineaCSV) {
		return new Estacion(lineaCSV);
	}
	
}
