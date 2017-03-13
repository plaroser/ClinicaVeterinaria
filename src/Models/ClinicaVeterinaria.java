package Models;

import java.util.ArrayList;
import java.util.Scanner;

public class ClinicaVeterinaria {
	private ArrayList<Animal> listaAnimales;
	private static ArrayList<String> acciones;
	private static ArrayList<String> tipoAnimales;

	/**
	 * Crea una nueva clinica e inicializa la lista de animales
	 */
	public ClinicaVeterinaria() {
		this.listaAnimales = new ArrayList<>();
	}

	/**
	 * Añade las acciones disponibles a la lista
	 */
	private static void aniadirTipoAcciones() {
		acciones = new ArrayList<>();
		acciones.add("Añadir animales");
		acciones.add("Modificar comentarios");
		acciones.add("Mostrar ficha de un animal");
		acciones.add("Salir");

	}

	/**
	 * Añade los tipos de animales disponibles a la lista
	 */
	private static void aniadirTipoAnimales() {
		tipoAnimales = new ArrayList<>();
		tipoAnimales.add("Añadir perro");
		tipoAnimales.add("Añadir gato");
		tipoAnimales.add("Añadir pajaro");
		tipoAnimales.add("Añadir reptil");
		tipoAnimales.add("Volver al menu principal");

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
	public void modificaComentarioAnimal(String nombreAnimal, String nuevoComentario) {
		if (buscarAnimal(nombreAnimal) != null) {
			buscarAnimal(nombreAnimal).setComentarios(nuevoComentario);
			System.out.println("Comentario modificado con exito.");
		} else {
			System.out.println("[ERROR] Animal no encontrado.");
		}
	}

	/*
	 * Muestra un menu con todos las opciones disponibles
	 * 
	 * @param elementos opciones de la lista disponibles
	 * 
	 * @return la opcion elegida. En el caso de que la lista este vacia devuelve
	 * -1.
	 */
	private int mostrarMenu(ArrayList<String> elementos) {
		System.out.println("--------------------------");
		for (int i = 0; i < elementos.size(); i++) {
			if (elementos.size() != 0) {

				System.out.println((i + 1) + ". " + elementos.get(i));

			} else {

				System.out.println("Lista vacia.");
				return -1;
			}

		}
		return leerOpcion(elementos.size());
	}

	/**
	 * Lee por teclado un numero de opciones dentro del rango introducido
	 * Empezando siempre por 1
	 * 
	 * @param opcionesMaximas
	 *            a elegir
	 * @return la opcion elegida empezando a partir de 1
	 */
	private static int leerOpcion(int opcionesMaximas) {
		Scanner sc = new Scanner(System.in);
		String aux;
		int numero = 0;
		boolean esCorrecto = false;
		System.out.print("Introduce la opción deseada: ");
		do {
			try {
				aux = sc.next();
				numero = Integer.parseInt(aux);
				esCorrecto = true;
				if (numero > opcionesMaximas || numero < 1) {
					esCorrecto = false;
					System.out.println("[ERROR] ha introducido un numero fuera de rango");
					System.out.println("Introduce de nuevo el número: ");
				}
			} catch (Exception e) {
				esCorrecto = false;
				System.out.println("No ha introducido un numero o no es valido.");
				System.out.println("Introduce de nuevo el número: ");
			}
			System.out.println("--------------------------");
		} while (esCorrecto == false);
		return numero;

	}

	/**
	 * Muestra el menu principal
	 * 
	 * @return la opcion elegida
	 */
	public int menuInicial() {
		aniadirTipoAcciones();
		return mostrarMenu(this.acciones);
	}

	private int aniadirAnimales() {
		aniadirTipoAnimales();
		return mostrarMenu(ClinicaVeterinaria.tipoAnimales);
	}

	/**
	 * Añade un animal a la lista de animales
	 * 
	 * @param a
	 *            Animal a añadir
	 */
	private void aniadirAnimal(Animal a) {
		this.listaAnimales.add(a);
	}

	/**
	 * Crea un nuevo perro
	 * 
	 * @return Devuelve el perro creado
	 */
	private Perro nuevoPerro() {
		Scanner sc = new Scanner(System.in);
		Animal a = nuevoAnimal();
		System.out.println("Introduce la raza del perro: ");
		String raza = sc.nextLine();
		System.out.println("Introduce el codigo del microchip del perro: ");
		String microchip = sc.nextLine();
		return new Perro(a.getNombre(), a.getFechaNachimiento(), a.getPeso(), raza, microchip);
	}

	/**
	 * Crea un nuevo gato
	 * 
	 * @return Devuelve el gato creado
	 */
	private Gato nuevoGato() {
		Scanner sc = new Scanner(System.in);
		Animal a = nuevoAnimal();
		System.out.println("Introduce la raza del gato: ");
		String raza = sc.nextLine();
		System.out.println("Introduce el codigo del microchip del gato: ");
		String microchip = sc.nextLine();
		return new Gato(a.getNombre(), a.getFechaNachimiento(), a.getPeso(), raza, microchip);
	}

	/**
	 * Crea un nuevo reptil
	 * 
	 * @return Devuelve el Reptil creado
	 */
	private Reptil nuevoReptil() {
		Scanner sc = new Scanner(System.in);
		Animal a = nuevoAnimal();
		System.out.println("Introduce la especie: ");
		String especie = sc.nextLine();
		System.out.println();
		System.out.println("Introduce si es venenoso: ");
		boolean venenoso = sioNo();
		return new Reptil(a.getNombre(), a.getFechaNachimiento(), a.getPeso(), especie, venenoso);
	}

	/**
	 * Crea un nuevo pajaro
	 * 
	 * @return Devuelve el Pajaro creado
	 */
	private Pajaro nuevoPajaro() {
		Scanner sc = new Scanner(System.in);
		Animal a = nuevoAnimal();
		System.out.println("Introduce la especie de pajaro: ");
		String especie = sc.nextLine();
		System.out.println("Introduce si da mucho ruido por las mañanas: ");
		boolean cantor = sioNo();
		return new Pajaro(a.getNombre(), a.getFechaNachimiento(), a.getPeso(), especie, cantor);
	}

	/**
	 * Crea un nuevo Animal
	 * 
	 * @return Devuelve el Animal creado
	 */
	private Animal nuevoAnimal() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del animal: ");
		String nombre = sc.nextLine();
		System.out.println("Introduce la fecha de nacimiento del animal: ");
		String fechaNacimiento = sc.nextLine();
		System.out.println("Introduce el peso del animal: ");
		Double peso = leerDoubleMayorDe0();
		return new Animal(nombre, fechaNacimiento, peso) {
		};
	}

	/**
	 * Muestra los animales disponibles y pide elegir uno. TRas esto lo crea y
	 * lo añade a la lista
	 */
	public void crearAnimal() {
		switch (aniadirAnimales()) {
		case 1:
			// Perro
			aniadirAnimal(nuevoPerro());
			break;
		case 2:
			// Gato
			aniadirAnimal(nuevoGato());
			break;
		case 3:
			aniadirAnimal(nuevoPajaro());
			// Pajaro
			break;
		case 4:
			// Reptil
			aniadirAnimal(nuevoReptil());
			break;
		default:
			break;

		}
	}

	/**
	 * Muestra la ficha de un animal
	 * 
	 * @param a
	 *            El nombre del animal a mostrar la ficha
	 * @return La ficha completa
	 */
	public String mostrarFichaAnimal(String a) {
		if (buscarAnimal(a) != null) {
			return buscarAnimal(a).toString();
		}
		return null;
	}
/**
 * Pide un Si o un No
 * @return La respuesta
 */
	private static boolean sioNo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("(Introduce \"s\" o \"n\" para responder)");
		boolean esCorrecto = false;
		boolean continuar = false;
		do {
			String aux = sc.next();
			aux = aux.toLowerCase();
			if (aux.equals("s") || aux.equals("n")) {
				if (aux.equals("n")) {
					return false;
				}

				esCorrecto = true;
			} else {
				System.out.println("ERROR: No ha introducido una opcion valida.");
				System.out.println("Por favor, vuelva a intentarlo.");
				esCorrecto = false;
			}
		} while (!esCorrecto);
		return true;
	}

	private static Double leerDoubleMayorDe0() {
		Scanner sc = new Scanner(System.in);
		String aux;
		Double numero = (double) 0;
		boolean esCorrecto = false;

		do {
			try {
				aux = sc.next();
				numero = Double.parseDouble(aux);
				esCorrecto = true;
				if (numero < 0) {
					System.out.println("[ERROR] No se puede introducir un número menor de 0.");
					esCorrecto = false;
				}
			} catch (Exception e) {
				esCorrecto = false;
				System.out.println("No ha introducido un numero o no es valido.");
			}
		} while (esCorrecto == false);
		return numero;

	}

	@Override
	public String toString() {
		String aux = "ClinicaVeterinaria lista De Animales: ";
		aux += "\n" + listaAnimales;
		return aux;
	}

}
