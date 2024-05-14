package br.edu.infnet.luiz.model.domain;

public abstract class Produto {

	private String nome;
	private int peso;
	private float preco;
	private Integer id;
	
	public String getNome() {
        return this.nome;
	}
	public void setNome(String nome) {

        this.nome = nome;
	}
	public int getPeso() {

        return this.peso;
	}
	public void setPeso(int peso) {

        this.peso = peso;
	}
	public float getPreco() {

        return this.preco;
	}
	public void setPreco(float preco) {

        this.preco = preco;
	}
	
	public Integer getId() {

        return this.id;
	}
	public void setId(Integer id) {

        this.id = id;
	}
    @Override
	public String toString() {
		return String.format("%s - %d - %.2f - %d",
                            this.nome,
                            this.peso,
                            this.preco,
                            this.id);
	}
	
	
}
