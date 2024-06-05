/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibliotecaapp_;

/**
 *
 * @author Isaiz
 */

import java.util.Scanner;

public class BibliotecaApp_ {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("---- Menú Biblioteca ----");
            System.out.println("1. Agregar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro por título");
            System.out.println("4. Buscar libro por autor");
            System.out.println("5. Editar libro");
            System.out.println("6. Eliminar libro");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    agregarLibro(biblioteca, scanner);
                    break;
                case 2:
                    listarLibros(biblioteca);
                    break;
                case 3:
                    buscarLibroPorTitulo(biblioteca, scanner);
                    break;
                case 4:
                    buscarLibroPorAutor(biblioteca, scanner);
                    break;
                case 5:
                    editarLibro(biblioteca, scanner);
                    break;
                case 6:
                    eliminarLibro(biblioteca, scanner);
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    private static void agregarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Año de Publicación: ");
        int anioPublicacion = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Libro libro = new Libro(titulo, autor, anioPublicacion, isbn);
        biblioteca.agregarLibro(libro);
        System.out.println("Libro agregado correctamente.");
    }

    private static void listarLibros(Biblioteca biblioteca) {
        System.out.println("Lista de todos los libros en la biblioteca:");
        biblioteca.listarLibros().forEach(System.out::println);
    }

    private static void buscarLibroPorTitulo(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Introduce el título del libro que quieres buscar: ");
        String titulo = scanner.nextLine();
        try {
            Libro libroBuscado = biblioteca.buscarPorTitulo(titulo)
                .orElseThrow(() -> new LibroNoEncontradoException("El libro con título '" + titulo + "' no se encontró."));
            System.out.println("Libro encontrado: " + libroBuscado);
        } catch (LibroNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void buscarLibroPorAutor(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Introduce el autor del libro que quieres buscar: ");
        String autor = scanner.nextLine();
        try {
            Libro libroBuscado = biblioteca.buscarPorAutor(autor)
                .orElseThrow(() -> new LibroNoEncontradoException("El libro con autor '" + autor + "' no se encontró."));
            System.out.println("Libro encontrado: " + libroBuscado);
        } catch (LibroNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void editarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Introduce el título del libro que quieres editar: ");
        String titulo = scanner.nextLine();

        System.out.println("Introduce los nuevos datos del libro:");
        System.out.print("Nuevo título: ");
        String nuevoTitulo = scanner.nextLine();

        System.out.print("Nuevo autor: ");
        String nuevoAutor = scanner.nextLine();

        System.out.print("Nuevo año de publicación: ");
        int nuevoAnioPublicacion = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        System.out.print("Nuevo ISBN: ");
        String nuevoIsbn = scanner.nextLine();

        Libro nuevoLibro = new Libro(nuevoTitulo, nuevoAutor, nuevoAnioPublicacion, nuevoIsbn);
        if (biblioteca.editarLibro(titulo, nuevoLibro)) {
            System.out.println("Libro editado correctamente.");
        } else {
            System.err.println("El libro con título '" + titulo + "' no se encontró.");
        }
    }

    private static void eliminarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Introduce el título del libro que quieres eliminar: ");
        String titulo = scanner.nextLine();
        if (biblioteca.eliminarLibro(titulo)) {
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.err.println("El libro con título '" + titulo + "' no se encontró.");
        }
    }
}
