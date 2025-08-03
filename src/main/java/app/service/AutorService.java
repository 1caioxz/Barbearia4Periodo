package app.service;

import app.entity.Autor;
import app.repository.AutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    //CREATE
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }


    // READ
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    //UPDATE
    public Autor update(Long id, Autor autorDetails) {
        Autor autor = findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Autor not found with id: " + id));

        autor.setNome(autorDetails.getNome());
        autor.setCpf(autorDetails.getCpf());
        autor.setIdade(autorDetails.getIdade());

        return autorRepository.save(autor);
    }

    //DELETE
    public void deleteById(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new EntityNotFoundException("Autor not found with id: " + id);
        }
        autorRepository.deleteById(id);
    }

    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }




}






