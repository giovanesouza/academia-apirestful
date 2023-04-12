package edu.giovane.academia.digital.entity.form;

import java.util.Objects;

public class AvaliacaoFisicaUpdateForm {

	private double peso;

	private double altura;

	// Contrutor vazio
	public AvaliacaoFisicaUpdateForm() {

	}
	
	
	// Construtor com todos os atributos
	public AvaliacaoFisicaUpdateForm(double peso, double altura) {
		this.peso = peso;
		this.altura = altura;
	}


	// Getters e Setters
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	
	// Equals e HashCode
	@Override
	public int hashCode() {
		return Objects.hash(altura, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoFisicaUpdateForm other = (AvaliacaoFisicaUpdateForm) obj;
		return Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso);
	}

}
