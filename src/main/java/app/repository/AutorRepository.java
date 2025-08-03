package app.repository;

import app.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    // JpaRepository provides all basic CRUD operations:
    // - findAll() - List all autor
    // - findById() - Find a autor by ID
    // - save() - Save a new autor or update an existing one
    // - deleteById() - Delete a autor by ID
    // - delete() - Delete a autor entity
}