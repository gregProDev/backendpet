package br.com.backendpet.cachorro.dtos;

import javax.validation.constraints.NotBlank;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class CachorroDto {

    //Variaveis
    @NotBlank
    public String nome;
    public String raca;
    public String cor;
    public String tamanho;
    public String idade;

    //construtor
    public CachorroDto(@NotBlank String nome, String raca, String cor, String tamanho, String idade) {
        this.nome = nome;
        this.raca = raca;
        this.cor = cor;
        this.tamanho = tamanho;
        this.idade = idade;

    }

    //Getter&Setters


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
