package app.repository;

import app.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    // JpaRepository provides all basic CRUD operations:
    // - findAll() - List all bibliotecas
    // - findById() - Find a biblioteca by ID
    // - save() - Save a new biblioteca or update an existing one
    // - deleteById() - Delete a biblioteca by ID
    // - delete() - Delete a biblioteca entity
}
