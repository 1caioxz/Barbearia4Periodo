package app.controller;

import app.entity.Livro;
import app.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    // MÉTODO POST - Criar Livro
    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {
        Livro savedLivro = livroService.save(livro);
        return new ResponseEntity<>(savedLivro, HttpStatus.CREATED);
    }

    // MÉTODO GET - Buscar todos os livros
    @GetMapping
    public ResponseEntity<List<Livro>> getAllLivros() {
        List<Livro> livros = livroService.findAll();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    // MÉTODO DELETE - Deletar livro por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // MÉTODO PUT - Atualizar livro por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Livro> updateLivro(@PathVariable Long id, @RequestBody Livro livroDetails) {
        Livro updatedLivro = livroService.update(id, livroDetails);
        return new ResponseEntity<>(updatedLivro, HttpStatus.OK);
    }
}
