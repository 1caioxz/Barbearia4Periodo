package app.controller;

import app.entity.Servico;
import app.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    private final ServicoService servicoService;

    @Autowired
    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    // Create a new Biblioteca
    @PostMapping
    public ResponseEntity<Servico> createServico(@RequestBody Servico servico) {
        Servico savedServico = servicoService.save(servico);
        return new ResponseEntity<>(savedServico, HttpStatus.CREATED);
    }

    // Get all Bibliotecas
    @GetMapping
    public ResponseEntity<List<Servico>> getAllServicos() {
        List<Servico> servicos = servicoService.findAll();
        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }

    // Get a single Biblioteca by ID
    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable Long id) {
        return new ResponseEntity<>(servicoService.findById(id), HttpStatus.OK);
    }

    // Update a Biblioteca
    @PutMapping("/{id}")
    public ResponseEntity<Servico> updateServico(
            @PathVariable Long id, 
            @RequestBody Servico servicoDetails) {
        return new ResponseEntity<>(servicoService.update(id, servicoDetails), HttpStatus.OK);
    }

    // Delete a Biblioteca
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable Long id) {
        servicoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
