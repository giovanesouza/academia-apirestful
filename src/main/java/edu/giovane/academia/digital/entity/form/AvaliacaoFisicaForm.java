package edu.giovane.academia.digital.entity.form;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

import java.util.Objects;

import edu.giovane.academia.digital.entity.Aluno;

/*
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
*/

//@Data // abstrai o Get, Set equals e hashcode
//@NoArgsConstructor // Cria construtor vazio
//@AllArgsConstructor // Cria construtor com todos os atributos
public class AvaliacaoFisicaForm {

//  @Positive(message = "O Id do aluno precisa ser positivo.")
	private Long alunoId;

//  @NotNull(message = "Preencha o campo corretamente.")
//  @Positive(message = "${validatedValue} precisa ser positivo.")
	private double peso;

//  @NotNull(message = "Preencha o campo corretamente.")
//  @Positive(message = "'${validatedValue}' precisa ser positivo.")
//  @DecimalMin(value = "150", message = "'${validatedValue}' precisa ser no mínimo {value}.")
	private double altura;

	// Contrutor vazio
	public AvaliacaoFisicaForm() {

	}

	
	// Getters e Setters
	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

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
		return Objects.hash(altura, alunoId, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoFisicaForm other = (AvaliacaoFisicaForm) obj;
		return Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura)
				&& Objects.equals(alunoId, other.alunoId)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso);
	}

}
