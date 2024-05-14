package br.edu.infnet.luiz.model.domain;

import java.util.List;

public class Padeiro {
	
	private Integer id;
	private String nome;
	private String cpf;
	private List<Produto> produtos;
	
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
                                               cpf);
	}	

}
