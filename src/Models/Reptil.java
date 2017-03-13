package Models;

public class Reptil extends Animal{
	public Reptil(String nombre, String fechaNachimiento, Double peso, String especie, boolean venenoso) {
		super(nombre, fechaNachimiento, peso);
		this.especie = especie;
		this.venenoso = venenoso;
	}
	private String especie;
	private boolean venenoso;
	
	@Override
	public String toString() {
		return "Ficha de Perro\n" 
				+ "Nombre: " + this.nombre 
				+ "\nEspecie: " + this.especie 
				+ "\nFecha de Nacimiento: "+ this.fechaNachimiento 
				+ "\nPeso: " + this.peso + " Kg" 
				+ "\nVenenoso: "+this.venenoso
				+ this.comentarios != null ? "Comentarios: " + this.comentarios : "";
	}
}
