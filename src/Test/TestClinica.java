package Test;

import java.util.Scanner;

import javax.swing.plaf.synth.Region;

import Models.ClinicaVeterinaria;

public class TestClinica {
	private static String GUIONES = "--------------------------";
	private static String ENCABEZADO =       "\t*************************\n"
            								+"\t*                       *\n"
            								+"\t*  CLINICA VETERINARIA  *\n"
            								+"\t*                       *\n"
            								+"\t*************************\n";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		ClinicaVeterinaria c = new ClinicaVeterinaria();
		System.out.println(ENCABEZADO);
		do {
			System.out.println(GUIONES);
			System.out.println("Lista de opciones disponibles.");
			String nombreAnimal;
			switch (c.menuInicial()) {
			case 1:
				// Añadir animales
				c.crearAnimal();
				break;
			case 2:
				// Modificar comentarios
				System.out.println("Introduce el nombre del animal: ");
				nombreAnimal = sc.nextLine();
				System.out.println("Introduce el nuevo comentario: ");
				String nuevoComentario = sc.nextLine();
				c.modificaComentarioAnimal(nombreAnimal, nuevoComentario);
				break;
			case 3:
				// Mostrar animal
				System.out.println("Introduce el nombre del animal que deseas ver la ficha: ");
				nombreAnimal = sc.nextLine();
				if (c.mostrarFichaAnimal(nombreAnimal) != null) {
					System.out.println(c.mostrarFichaAnimal(nombreAnimal));
				} else {
					System.out.println("[ERROR] Animal no encontrado");
				}
				break;
			case 4:
				salir = true;
				break;

			}
		} while (!salir);
	}

}
