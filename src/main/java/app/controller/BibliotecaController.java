package app.controller;

import app.entity.Biblioteca;
import app.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecas")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    @Autowired
    public BibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    // Create a new Biblioteca
    @PostMapping
    public ResponseEntity<Biblioteca> createBiblioteca(@RequestBody Biblioteca biblioteca) {
        Biblioteca savedBiblioteca = bibliotecaService.save(biblioteca);
        return new ResponseEntity<>(savedBiblioteca, HttpStatus.CREATED);
    }

    // Get all Bibliotecas
    @GetMapping
    public ResponseEntity<List<Biblioteca>> getAllBibliotecas() {
        List<Biblioteca> bibliotecas = bibliotecaService.findAll();
        return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
    }

    // Get a single Biblioteca by ID
    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> getBibliotecaById(@PathVariable Long id) {
        return new ResponseEntity<>(bibliotecaService.findById(id), HttpStatus.OK);
    }

    // Update a Biblioteca
    @PutMapping("/{id}")
    public ResponseEntity<Biblioteca> updateBiblioteca(
            @PathVariable Long id, 
            @RequestBody Biblioteca bibliotecaDetails) {
        return new ResponseEntity<>(bibliotecaService.update(id, bibliotecaDetails), HttpStatus.OK);
    }

    // Delete a Biblioteca
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBiblioteca(@PathVariable Long id) {
        bibliotecaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
