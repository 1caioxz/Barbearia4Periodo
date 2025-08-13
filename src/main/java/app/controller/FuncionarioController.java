package app.controller;

import app.entity.Funcionario;
import app.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping
    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Funcionario adicionar(@RequestBody Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Funcionario removida com sucesso";
        }
        return "Funcionario não encontrada";
    }

    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody Funcionario novaFuncionario) {
        return repository.findById(id).map(funcionario -> {
            funcionario.setNome(novaFuncionario.getNome());
            funcionario.setTelefone(novaFuncionario.getTelefone());
            funcionario.setEndereco(novaFuncionario.getEndereco());
            return repository.save(funcionario);
        }).orElse(null);
    }
}
