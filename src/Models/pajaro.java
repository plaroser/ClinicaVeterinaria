package Models;

public class pajaro extends Animal{
private String especie;
	private boolean cantor;

	public pajaro(String nombre, String fechaNachimiento, Double peso, String especie, boolean cantor) {
		super(nombre, fechaNachimiento, peso);
		this.especie = especie;
		this.cantor = cantor;
	}

	@Override
	public String toString() {
		return "Ficha de Gato\n" 
				+ "Nombre: " + this.nombre 
				+"\nEspecie: "+this.especie
				+"\nDa mucho la lata por las mñanas: "+this.cantor
				+ "\nFecha de Nacimiento: "+ this.fechaNachimiento 
				+ "\nPeso: " + this.peso + " Kg" 
				+ this.comentarios != null ? "Comentarios: " + this.comentarios : "";
	}
	
}
