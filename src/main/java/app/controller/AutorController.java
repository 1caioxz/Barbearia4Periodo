package app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Autor;
import app.service.AutorService;
@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

@PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Autor autor){
        try{
         String mensagem =    this.autorService.save(autor);
         return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<String>("Deu algo errado ao salvar!", HttpStatus.BAD_REQUEST);

        }
    }


}
