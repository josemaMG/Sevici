package tipo.Estaciones;

import java.util.Objects;

public class Coordenadas {
	
	private Double longitud, latitud;

	public Coordenadas(Double longitud, Double latitud) {
		
		if (latitud>90.0 || latitud<-90.0) {
			throw new IllegalArgumentException();
		}
		
		if (longitud<-180.0 || longitud>180.0) {
			throw new IllegalArgumentException();
		}
		
		this.longitud = longitud;
		this.latitud = latitud;
	}
	
	public Coordenadas() {
		this.longitud = 0.;
		this.latitud = 0.;
	}
	
	public Coordenadas(String coords) {
		if (coords.replace("(", "").replace(")","").split(",").length!=2) {
			throw new IllegalArgumentException();
		}
		
		if (Double.valueOf(coords.replace("(", "").replace(")","").split(",")[1].trim())>90.0 || Double.valueOf(coords.replace("(", "").replace(")","").split(",")[1].trim())<-90.0) {
			throw new IllegalArgumentException();
		}
		
		if (Double.valueOf(coords.replace("(", "").replace(")","").split(",")[0].trim())<-180.0 || Double.valueOf(coords.replace("(", "").replace(")","").split(",")[0].trim())>180.0) {
			throw new IllegalArgumentException();
		}
		
		this.longitud = Double.valueOf(coords.replace("(", "").replace(")","").split(",")[0].trim());
		this.latitud = Double.valueOf(coords.replace("(", "").replace(")","").split(",")[1].trim());
	}
	
	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		
		if (longitud<-180.0 || longitud>180.0) {
			throw new IllegalArgumentException();
		}
		
		this.longitud = longitud;
	}

	public Double getLatitud() {
		
		if (latitud>90.0 || latitud<-90.0) {
			throw new IllegalArgumentException();
		}
		
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	
	public Hemisferio getHemisferio() {
		Hemisferio result= Hemisferio.NORTE;
		if (latitud<0.0) {
			result=Hemisferio.SUR;
		}
		return result;
	}

	public Double getDistancia(Coordenadas c) {
		return Math.sqrt(Math.pow(longitud-c.longitud,2)+Math.pow(latitud-c.latitud,2));
	}
	
	public int hashCode() {
		return Objects.hash(latitud, longitud);
	}

	public boolean equals(Object obj) {
		boolean result=false;
		if (getClass() == obj.getClass()) {
			Coordenadas other = (Coordenadas) obj;
			result= Objects.equals(latitud, other.latitud) && Objects.equals(longitud, other.longitud);
		}
		return result;
	}
	
	public String toString() {
		return "Coordenadas [longitud=" + longitud + ", latitud=" + latitud + "]";
	}
	
}
	