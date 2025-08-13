package app.repository;

import app.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // JpaRepository provides all basic CRUD operations:
    // - findAll() - List all Cliente
    // - findById() - Find a Cliente by ID
    // - save() - Save a new Cliente or update an existing one
    // - deleteById() - Delete a Cliente by ID
    // - delete() - Delete a Cliente entity
}