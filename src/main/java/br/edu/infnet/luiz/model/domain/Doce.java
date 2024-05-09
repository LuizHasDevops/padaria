package br.edu.infnet.luiz.model.domain;



public class Doce extends Produto{

	private boolean light;
	private boolean sorvete;
	
	public boolean isLight() {
		return light;
	}
	public void setLight(boolean light) {
		this.light = light;
	}
	public boolean isSorvete() {
		return sorvete;
	}
	public void setSorvete(boolean sorvete) {
		this.sorvete = sorvete;
	}
	@Override
	public String toString() {
		return super.toString()+"Doce [light=" + light + ", sorvete=" + sorvete + "]";
	}
		
	
}
