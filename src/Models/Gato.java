package Models;

public class Gato extends Animal {
	private String raza;
	private String microchip;

	public Gato(String nombre, String fechaNachimiento, Double peso, String raza, String microchip) {
		super(nombre, fechaNachimiento, peso);
		this.raza = raza;
		this.microchip = microchip;
	}

	@Override
	public String toString() {
		String comentarios;
		if (this.comentarios != null) {
			comentarios = "\nComentarios: " + this.comentarios;
		} else {
			comentarios = "";
		}
		return "Ficha de Gato\n" + "Nombre: " + this.nombre + "\nRaza: " + this.raza + "\nFecha de Nacimiento: "
				+ this.fechaNachimiento + "\nPeso: " + this.peso + " Kg" + "\nMicrochip" + this.microchip + comentarios;
	}

}
