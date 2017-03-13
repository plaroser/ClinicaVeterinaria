package Models;

public class Perro extends Animal {
	private String raza;
	private String microchip;

	public Perro(String nombre, String fechaNachimiento, Double peso, String raza, String microchip) {
		super(nombre, fechaNachimiento, peso);
		this.raza = raza;
		this.microchip = microchip;
	}

	@Override
	public String toString() {
		return "Ficha de Perro\n" + "Nombre: " + this.nombre + "\nRaza: " + this.raza + "\nFecha de Nacimiento: "
				+ this.fechaNachimiento + "\nPeso: " + this.peso + " Kg" + "\nMicrochip" + this.microchip
				+ this.comentarios != null ? "Comentarios: " + this.comentarios : "";
	}

}
