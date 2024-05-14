package br.edu.infnet.luiz.model.domain;



public class Doce extends Produto{

	private boolean light;
	private boolean sorvete;
	
	public boolean isLight() {
		   return this.light;
	}
	public void setLight(boolean light) {
		   this.light = light;
	}
	public boolean isSorvete() {
		   return this.sorvete;
	}
	public void setSorvete(boolean sorvete) {
		   this.sorvete = sorvete;
	}
	@Override
	public String toString() {
		return String.format("%s - %s - %s",
                       super.toString(),
                       this.light,
                       this.sorvete);
	}

}
