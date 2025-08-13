package app.repository;

import app.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    // JpaRepository provides all basic CRUD operations:
    // - findAll() - List all Servicos
    // - findById() - Find a Servico by ID
    // - save() - Save a new Servico or update an existing one
    // - deleteById() - Delete a Servico by ID
    // - delete() - Delete a Servico entity
}
