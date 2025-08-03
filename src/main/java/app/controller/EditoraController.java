package app.controller;

import app.entity.Editora;
import app.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraRepository repository;

    @GetMapping
    public List<Editora> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Editora buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Editora adicionar(@RequestBody Editora editora) {
        return repository.save(editora);
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Editora removida com sucesso";
        }
        return "Editora não encontrada";
    }

    @PutMapping("/{id}")
    public Editora atualizar(@PathVariable Long id, @RequestBody Editora novaEditora) {
        return repository.findById(id).map(editora -> {
            editora.setNome(novaEditora.getNome());
            editora.setTelefone(novaEditora.getTelefone());
            editora.setEndereco(novaEditora.getEndereco());
            return repository.save(editora);
        }).orElse(null);
    }
}
