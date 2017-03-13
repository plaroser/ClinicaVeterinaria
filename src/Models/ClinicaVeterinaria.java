package Models;

import java.util.ArrayList;

public class ClinicaVeterinaria {
	private ArrayList<Animal> listaAnimales;

	/**
	 * Crea una nueva clinica e inicializa la lista de animales
	 */
	public ClinicaVeterinaria() {
		this.listaAnimales = new ArrayList<>();
	}

	/**
	 * Inserta a un animal dentro de la lista de animales de la clinica
	 * 
	 * @param animal
	 *            Animal a insertar dentro de la lista
	 */
	private void insertarAnimal(Animal animal) {
		this.listaAnimales.add(animal);
	}

	/**
	 * Busca un animal dentro de la lista de animales
	 * 
	 * @param nombre
	 *            El nombre por el que queremos buscar al animal
	 * @return Animal con dicho nombre o null si no lo encuentra
	 */
	private Animal buscarAnimal(String nombre) {
		if (listaAnimales.size() > 0) {
			for (int i = 0; i < listaAnimales.size(); i++) {
				if (nombre.equals(listaAnimales.get(i).getNombre())) {
					return listaAnimales.get(i);
				}
			}
		}
		return null;

	}
}
