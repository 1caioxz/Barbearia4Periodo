package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Biblioteca {

    @Id
    private Long id;

    private String nome;
    private String telefone;

    public Biblioteca(Long id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Biblioteca() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setTelefone(String telefone) {
    this.telefone = telefone;
    }
    public String getTelefone() {
        return telefone;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
