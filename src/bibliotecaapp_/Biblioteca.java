/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaapp_;

/**
 *
 * @author Isaiz
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Biblioteca implements GestionBiblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    @Override
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    @Override
    public List<Libro> listarLibros() {
        return new ArrayList<>(libros);
    }

    @Override
    public Optional<Libro> buscarPorTitulo(String titulo) {
        return libros.stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }

    @Override
    public Optional<Libro> buscarPorAutor(String autor) {
        return libros.stream()
                .filter(libro -> libro.getAutor().equalsIgnoreCase(autor))
                .findFirst();
    }

    public boolean eliminarLibro(String titulo) {
        return libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
    }

    public boolean editarLibro(String titulo, Libro nuevoLibro) {
        Optional<Libro> libroOpt = buscarPorTitulo(titulo);
        if (libroOpt.isPresent()) {
            Libro libro = libroOpt.get();
            libro.setTitulo(nuevoLibro.getTitulo());
            libro.setAutor(nuevoLibro.getAutor());
            libro.setAnioPublicacion(nuevoLibro.getAnioPublicacion());
            libro.setIsbn(nuevoLibro.getIsbn());
            return true;
        }
        return false;
    }
}
