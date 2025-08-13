package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ISSN;
    private String titulo;
    private String sinopse;
    private Integer ano;
    private Integer qtdPaginas;


    public Agendamento(Long id, String ISSN, String titulo, String sinopse, Integer ano, Integer qtdPaginas) {
        this.id = id;
        this.ISSN = ISSN;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.ano = ano;
        this.qtdPaginas = qtdPaginas;

    }

    public Agendamento() {
    }


    public Long getId() {
        return id;
    }

    public String getISSN() {
        return ISSN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public Integer getAno() {
        return ano;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }





}
