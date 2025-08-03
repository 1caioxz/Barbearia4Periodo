package app.repository;

import app.entity.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
    // JpaRepository provides all basic CRUD operations:
    // - findAll() - List all bibliotecas
    // - findById() - Find a biblioteca by ID
    // - save() - Save a new biblioteca or update an existing one
    // - deleteById() - Delete a biblioteca by ID
    // - delete() - Delete a biblioteca entity
}
