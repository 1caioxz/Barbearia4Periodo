package app.repository;

import app.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    // JpaRepository provides all basic CRUD operations:
    // - findAll() - List all Agendamentos
    // - findById() - Find a Agendamento by ID
    // - save() - Save a new Agendamento or update an existing one
    // - deleteById() - Delete a Agendamento by ID
    // - delete() - Delete a Agendamento entity
}
