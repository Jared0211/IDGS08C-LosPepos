/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaapp_;

/**
 *
 * @author Isaiz
 */
import java.util.List;
import java.util.Optional;

public interface GestionBiblioteca {
    void agregarLibro(Libro libro);
    List<Libro> listarLibros();
    Optional<Libro> buscarPorTitulo(String titulo);
    Optional<Libro> buscarPorAutor(String autor);
}

