package pe.com.apiconz.example.dummies;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 9019188096383217542L;
	private String nombre;
	private String palabraElegida;
	private String numero;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPalabraElegida() {
		return palabraElegida;
	}

	public void setPalabraElegida(String palabraElegida) {
		this.palabraElegida = palabraElegida;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
