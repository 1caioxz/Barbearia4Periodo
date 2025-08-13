package app.service;

import app.entity.Cliente;
import app.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //CREATE
    public static Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    // READ
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    //UPDATE
    public Cliente update(Long id, Cliente clienteDetails) {
        Cliente cliente = findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente not found with id: " + id));

        cliente.setNome(clienteDetails.getNome());
        cliente.setCpf(clienteDetails.getCpf());
        cliente.setIdade(clienteDetails.getIdade());

        return clienteRepository.save(cliente);
    }

    //DELETE
    public void deleteById(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new EntityNotFoundException("cliente not found with id: " + id);
        }
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }




}






