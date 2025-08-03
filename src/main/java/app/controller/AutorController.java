package app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.entity.Autor;
import app.service.AutorService;

import java.util.List;


@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    //METODO POST
    @PostMapping
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
        Autor savedAutor = autorService.save(autor);
        return new ResponseEntity<>(savedAutor, HttpStatus.CREATED);
    }
    //METODO GET
    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutor() {
        List<Autor> autor = autorService.findAll();
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }
    //METODO DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
    autorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //METODO UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<Autor> updateAutor(
            @PathVariable Long id,
            @RequestBody Autor autorDetails) {
        return new ResponseEntity<>(autorService.update(id, autorDetails), HttpStatus.OK);
    }


}
