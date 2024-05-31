package br.edu.infnet.luiz.model.domain;

public class Pao extends Produto{
	
	private boolean integral;
    private int quantidade;
	
	public boolean isIntegral() {

        return this.integral;
	}
	public void setIntegral(boolean integral) {

        this.integral = integral;
	}
	public int getQuantidade() {

        return this.quantidade;
	}
	public void setQuantidade(int quantidade) {

        this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return String.format("%s - %s - %d",
                      super.toString(),
                      this.integral,
                      this.quantidade);
	}

}
