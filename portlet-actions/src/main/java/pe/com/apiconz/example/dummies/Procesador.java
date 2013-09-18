package pe.com.apiconz.example.dummies;

public class Procesador {

	public static Cliente getClientePorPalabra(String palabra) {
		Cliente cliente = new Cliente();
		cliente.setNombre("William");
		cliente.setNumero("1");
		cliente.setPalabraElegida(palabra);

		return cliente;
	}

}
