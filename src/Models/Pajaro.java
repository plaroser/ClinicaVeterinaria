package Models;

public class Pajaro extends Animal {
	private String especie;
	private boolean cantor;

	public Pajaro(String nombre, String fechaNachimiento, Double peso, String especie, boolean cantor) {
		super(nombre, fechaNachimiento, peso);
		this.especie = especie;
		this.cantor = cantor;
	}

	@Override
	public String toString() {
		String comentarios;
		if (this.comentarios != null) {
			comentarios = "\nComentarios: " + this.comentarios;
		} else {
			comentarios = "";
		}
		return "Ficha de Gato\n" + "Nombre: " + this.nombre + "\nEspecie: " + this.especie
				+ "\nDa mucho la lata por las mñanas: " + this.cantor + "\nFecha de Nacimiento: "
				+ this.fechaNachimiento + "\nPeso: " + this.peso + " Kg" + comentarios;
	}

}
