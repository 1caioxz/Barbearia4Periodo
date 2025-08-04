package app.service;

import app.entity.Livro;
import app.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    // Create
    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    // Read
    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro not found with id: " + id));
    }


    // Update
public Livro update(Long id, Livro livroDetails) {
    Livro livro = findById(id);
    livro.setISSN(livroDetails.getISSN());
    livro.setTitulo(livroDetails.getTitulo());
    livro.setSinopse(livroDetails.getSinopse());
    livro.setAno(livroDetails.getAno());
    livro.setQtdPaginas(livroDetails.getQtdPaginas());
    return livroRepository.save(livro);
}


    // Delete
    public void deleteById(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new EntityNotFoundException("Livro not found with id: " + id);
        }
        livroRepository.deleteById(id);
    }
}
