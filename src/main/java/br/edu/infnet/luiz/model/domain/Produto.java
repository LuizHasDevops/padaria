package br.edu.infnet.luiz.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {
    @NotBlank
    @Column(name = "dsproduto")
	private String nome;
	private int peso;
    @Min(value = 1, message = "O preço do produto precisa ser maior ou igual a {value}")
    @Column(name = "vlproduto")
	private float preco;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @ManyToOne
    @JoinColumn(name = "idPadeiro")
    @JsonBackReference
    private Padeiro padeiro;

    public Padeiro getPadeiro(){
        return padeiro;
    }

    public void setPadeiro(Padeiro padeiro) {
        this.padeiro = padeiro;
    }

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
