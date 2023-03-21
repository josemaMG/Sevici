package tipo.Estaciones;

import java.util.Objects;

public class Estacion {
	private String nombre;
	private Integer puestos,bicisDisponibles;
	private Coordenadas ubicacion;
	
	private void checkPuestos(Integer puestos) {
		if (puestos<=0) {
			throw new IllegalArgumentException();
		}
		
	}
	
	private void checkBicisDisponibles(Integer puestos, Integer bicisDisponibles) {
		if (bicisDisponibles<0 || bicisDisponibles>puestos) {
			throw new IllegalArgumentException();
		}
		
	}
	
	public Estacion(String nombre, Integer puestos, Integer bicisDisponibles, Coordenadas ubicacion) {
		checkPuestos(puestos);
		checkBicisDisponibles(puestos, bicisDisponibles);
		
		this.nombre = nombre;
		this.puestos = puestos;
		this.bicisDisponibles = bicisDisponibles;
		this.ubicacion = ubicacion;
	}
	
	public Estacion(String linea) {
		String [] splits = linea.split(",");
		if(splits.length!=4) {
			throw new IllegalArgumentException();
		}
		
		checkPuestos(Integer.valueOf(splits[1].trim()));
		checkBicisDisponibles(Integer.valueOf(splits[1].trim()), Integer.valueOf(splits[2].trim()));
		
		this.nombre = splits[0].trim();
		this.puestos = Integer.valueOf(splits[1].trim());
		this.bicisDisponibles = Integer.valueOf(splits[2].trim());
		this.ubicacion = new Coordenadas(Double.valueOf(splits[3].trim()), Double.valueOf(splits[4].trim()));
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Integer getPuestos() {
		return puestos;
	}
	
	
	public Integer getBicisDisponibles() {
		return bicisDisponibles;
	}

	public Coordenadas getUbicacion() {
		return ubicacion;
	}
	
	public void setBicisDisponibles(Integer bicisDisponibles) {
		checkBicisDisponibles(puestos, bicisDisponibles);
		this.bicisDisponibles = bicisDisponibles;
	}
	
	public Integer getPuestosVacios() {
		return puestos-bicisDisponibles;
	}
	
	public boolean getTieneBicisDisponibles() {
		return bicisDisponibles>0;
	}

	public int hashCode() {
		return Objects.hash(nombre);
	}

	public boolean equals(Object obj) {
		boolean result=false;
		if (getClass() == obj.getClass()) {
			Estacion other = (Estacion) obj;
			result = Objects.equals(nombre, other.nombre);
		}
		return result;
	}

	public String toString() {
		return "Estacion [nombre=" + nombre + ", puestos=" + puestos + ", bicisDisponibles=" + bicisDisponibles+ ", ubicacion=" + ubicacion + "]";
	}
	
}
