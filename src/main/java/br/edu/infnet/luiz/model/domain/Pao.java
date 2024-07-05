package br.edu.infnet.luiz.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;

@Entity
@Table(name = "TPao")
public class Pao extends Produto{
	
	private boolean integral;
    private String calorias;

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    @Max(value = 40)
    @Column(name = "qtMaxima")
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
		return String.format("%s - %s - %d, %s",
                      super.toString(),
                      this.integral,
                      this.quantidade,
                      this.getCalorias());
	}

}
