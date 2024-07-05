package br.edu.infnet.luiz.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "TPadeiro")
public class Padeiro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @NotBlank(message = "É necessário preencher o campo NOME!")
    @Size(min = 3, max = 100, message = "O nome do vendedor deve ter entre {min} e {max} caracteres.")
	private String nome;
    @NotBlank(message = "É necessário preencher o campo CPF!")
    @Column(unique = true)
	private String cpf;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idPadeiro")
    @JsonManagedReference
	private List<Produto> produtos;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;
    public Padeiro(){

        this.produtos = new ArrayList<Produto>();
    }
    public Padeiro(Integer id){
        this();
        this.setId(id);
    }
	
	public String getNome() {

        return nome;
	}
	public void setNome(String nome) {

        this.nome = nome;
	}
	public String getCpf() {

        return cpf;
	}
	public void setCpf(String cpf) {

        this.cpf = cpf;
	}
	public List<Produto> getProdutos() {

        return produtos;
	}
	public void setProdutos(List<Produto> produtos) {

        this.produtos = produtos;
	}
	
	public Integer getId() {

        return id;
	}
	public void setId(Integer id) {

        this.id = id;
	}

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
	public String toString() {
		return String.format("%d - %s - %s - Endereço: %s",id,
                                               nome,
                                               cpf,
                                               endereco,
                                               produtos.size());
	}	

}
