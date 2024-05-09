package br.edu.infnet.luiz.model.domain;

public class Pao extends Produto{
	
	private boolean integral;
	private int quantidade;
	
	public boolean isIntegral() {
		return integral;
	}
	public void setIntegral(boolean integral) {
		this.integral = integral;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return super.toString()+"Pao [integral=" + this.integral + ", quantidade=" + this.quantidade + "]";
	}

	
}
