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
	 * @param nombreAnimal
	 *            El nombre por el que queremos buscar al animal
	 * @return Animal con dicho nombre o null si no lo encuentra
	 */
	private Animal buscarAnimal(String nombreAnimal) {
		if (listaAnimales.size() > 0) {
			for (int i = 0; i < listaAnimales.size(); i++) {
				if (nombreAnimal.equals(listaAnimales.get(i).getNombre())) {
					return listaAnimales.get(i);
				}
			}
		}
		return null;

	}

	/**
	 * modifica el comentario en la ficha del animal que está en la lista
	 * 
	 * @param nombreAnimal
	 *            Nombre del animal que le queremos modificar el comentario
	 * @param nuevoComentario
	 *            Nuevo comentario que le queremos asignar al animal.
	 */
	private void modificaComentarioAnimal(String nombreAnimal, String nuevoComentario) {
		if (buscarAnimal(nombreAnimal) != null) {
			buscarAnimal(nombreAnimal).setComentarios(nuevoComentario);
		} else {
			System.out.println("[ERROR] Animal no encontrado.");
		}
	}

	@Override
	public String toString() {
		String aux = "ClinicaVeterinaria lista De Animales: ";
		aux += "\n" + listaAnimales;
		return aux;
	}

}
