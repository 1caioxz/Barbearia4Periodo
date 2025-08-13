package app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.entity.Cliente;
import app.service.ClienteService;

import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //METODO POST
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente savedCliente = ClienteService.save(cliente);
        return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
    }
    //METODO GET
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllCliente() {
        List<Cliente> cliente = clienteService.findAll();
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    //METODO DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
    clienteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //METODO UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> updateCliente(
            @PathVariable Long id,
            @RequestBody Cliente clienteDetails) {
        return new ResponseEntity<>(clienteService.update(id, clienteDetails), HttpStatus.OK);
    }


}
