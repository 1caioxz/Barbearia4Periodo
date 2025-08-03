package app.service;

import app.entity.Editora;
import app.repository.EditoraRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {

    private final EditoraRepository editoraRepository;

    @Autowired
    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    public Editora save(Editora editora) {
        return editoraRepository.save(editora);
    }

    public List<Editora> findAll() {
        return editoraRepository.findAll();
    }

    public Editora findById(Long id) {
        return editoraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Editora not found with id: " + id));
    }

    public Editora update(Long id, Editora novaEditora) {
        Editora editora = findById(id);
        editora.setNome(novaEditora.getNome());
        editora.setEndereco(novaEditora.getEndereco());
        editora.setTelefone(novaEditora.getTelefone());
        return editoraRepository.save(editora);
    }

    public void delete(Long id) {
        if (!editoraRepository.existsById(id)) {
            throw new EntityNotFoundException("Editora not found with id: " + id);
        }
        editoraRepository.deleteById(id);
    }
}
