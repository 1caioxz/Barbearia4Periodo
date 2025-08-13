package app.service;

import app.entity.Agendamento;
import app.repository.AgendamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    @Autowired
    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    // Create
    public Agendamento save(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    // Read
    public List<Agendamento> findAll() {
        return agendamentoRepository.findAll();
    }

    public Agendamento findById(Long id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro not found with id: " + id));
    }


    // Update
public Agendamento update(Long id, Agendamento livroDetails) {
    Agendamento agendamento = findById(id);
    agendamento.setISSN(livroDetails.getISSN());
    agendamento.setTitulo(livroDetails.getTitulo());
    agendamento.setSinopse(livroDetails.getSinopse());
    agendamento.setAno(livroDetails.getAno());
    agendamento.setQtdPaginas(livroDetails.getQtdPaginas());
    return agendamentoRepository.save(agendamento);
}


    // Delete
    public void deleteById(Long id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Agendamento not found with id: " + id);
        }
        agendamentoRepository.deleteById(id);
    }
}
