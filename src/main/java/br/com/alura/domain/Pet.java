package br.com.alura.domain;

public class Pet {
    private long id;
    private String tipo;
    private String nome;
    private String raca;
    private int idade;
    private String cor;
    private Float peso;

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    public Float getPeso() {
        return peso;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Pet() {
    }

    public Pet(String tipo, String nome, String raca, int idade, String cor, Float peso) {
        setTipo(tipo);
        setNome(nome);
        setRaca(raca);
        setIdade(idade);
        setCor(cor);
        setPeso(peso);
    }

    @Override
    public String toString() {
        return  getNome() +" "+  getRaca() +" "+ getIdade() +" "+  getCor() +" "+ getPeso();
    }

    
}
