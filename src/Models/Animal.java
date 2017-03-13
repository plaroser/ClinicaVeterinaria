package Models;

public abstract class Animal {
	protected String nombre;
	protected String fechaNachimiento;
	protected Double peso;
	protected String comentarios;
	
	public Animal(String nombre, String fechaNachimiento, Double peso) {
		super();
		this.nombre = nombre;
		this.fechaNachimiento = fechaNachimiento;
		this.peso = peso;
		this.comentarios = null;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getNombre() {
		return nombre;
	}
	public String getFechaNachimiento() {
		return fechaNachimiento;
	}
	

}
