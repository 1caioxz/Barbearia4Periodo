package app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    private Long id;
    private String nome;
    private String Cpf;
    private Integer Idade;

    public Cliente(Long id, String nome, String cpf, Integer idade) {
        this.id = id;
        this.nome = nome;
        Cpf = cpf;
        Idade = idade;
    }
    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public Integer getIdade() {
        return Idade;
    }

    public void setIdade(Integer idade) {
        Idade = idade;
    }
}
