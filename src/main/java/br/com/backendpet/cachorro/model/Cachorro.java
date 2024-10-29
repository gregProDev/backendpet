package br.com.backendpet.cachorro.model;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "Cachorro")
public class Cachorro {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCachorro;
    private String nome;
    private String raca;
    private String cor;
    private String tamanho;
    private String idade;

    public UUID getIdCachorro() {
        return idCachorro;
    }

    public void setIdCachorro(UUID idCachorro) {
        this.idCachorro = idCachorro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
