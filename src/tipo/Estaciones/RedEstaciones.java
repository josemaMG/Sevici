package tipo.Estaciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class RedEstaciones {

	private List<Estacion> estaciones;
	
	public RedEstaciones() {
		estaciones=new ArrayList<>();
	}

	public RedEstaciones(String linea) {
		estaciones=new ArrayList<>(List.of(new Estacion(linea)));
	}
	
	public List<Estacion> getEstaciones() {
		return new ArrayList<>(estaciones);
	}
	
	public void añadirEstacion(Estacion e) {
		estaciones.add(e);
	}
		
	public Integer getNumeroEstaciones() {
		return estaciones.size();
	}
	
	public List<Estacion> getEstacionesBicisDisponibles() {
		List<Estacion> result= new ArrayList<>();
		for (Estacion e:estaciones) {
			if (e.getTieneBicisDisponibles()) {
			result.add(e);
			}
		}
		return result;
	}
	
	public List<Estacion> getEstacionesBicisDisponibles(int k) {
		List<Estacion> result= new ArrayList<>();
		for (Estacion e:estaciones) {
			if (e.getBicisDisponibles()>=k) {
			result.add(e);
			}
		}
		return result;
	}
	
	public SortedSet<Estacion> getEstacionesCercanas(Coordenadas cs, double d) {
		SortedSet<Estacion> result = new TreeSet<Estacion>();
		for (Estacion e:getEstacionesBicisDisponibles()) {
			if (e.getUbicacion().getDistancia(cs)<=d) {
				result.add(e);
			}
		}
		return result;
	}

	public Set<Coordenadas> getUbicacionEstaciones() {
		Set<Coordenadas> result= new HashSet<>();
		for (Estacion e: estaciones) {
			result.add(e.getUbicacion());
		}
		return result;
	}
	
	public Set<Coordenadas> getUbicacionEstacionesDisponibles(int k) {
		Set<Coordenadas> result= new HashSet<>();
		for (Estacion e: getEstacionesBicisDisponibles(k)) {
			result.add(e.getUbicacion());
		}
		return result;
	}
	
	public Estacion getEstacionMasBicisDisponibles() {
		Estacion result= new Estacion("",0,0,new Coordenadas());
		for (Estacion e: estaciones) {
			if (result.getBicisDisponibles()<e.getBicisDisponibles()) {
				result=e;
			}
		}
		return result;
	}
	
}
