package app.service;

import app.entity.Biblioteca;
import app.repository.BibliotecaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    @Autowired
    public BibliotecaService(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    // Create
    public Biblioteca save(Biblioteca biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }

    // Read
    public List<Biblioteca> findAll() {
        return bibliotecaRepository.findAll();
    }

    public Biblioteca findById(Long id) {
        return bibliotecaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Biblioteca not found with id: " + id));
    }

    // Update
    public Biblioteca update(Long id, Biblioteca bibliotecaDetails) {
        Biblioteca biblioteca = findById(id);
        biblioteca.setNome(bibliotecaDetails.getNome());
        biblioteca.setTelefone(bibliotecaDetails.getTelefone());
        return bibliotecaRepository.save(biblioteca);
    }

    // Delete
    public void deleteById(Long id) {
        if (!bibliotecaRepository.existsById(id)) {
            throw new EntityNotFoundException("Biblioteca not found with id: " + id);
        }
        bibliotecaRepository.deleteById(id);
    }
}
