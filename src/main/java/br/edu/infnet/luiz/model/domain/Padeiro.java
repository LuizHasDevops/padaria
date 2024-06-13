package br.edu.infnet.luiz.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "TPadeiro")
public class Padeiro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idPadeiro")
    @JsonManagedReference
	private List<Produto> produtos;
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
	@Override
	public String toString() {
		return String.format("%d - %s - %s - ",id,
                                               nome,
                                               cpf,
                                               produtos.size());
	}	

}
