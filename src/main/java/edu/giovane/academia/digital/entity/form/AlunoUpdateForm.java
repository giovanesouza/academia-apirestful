package edu.giovane.academia.digital.entity.form;

import java.time.LocalDate;
import java.util.Objects;

public class AlunoUpdateForm {

	private String nome;

	private String bairro;

	private LocalDate dataDeNascimento;

	// Contrutor vazio
	public AlunoUpdateForm() {

	}

	// Construtor com todos os atributos
	public AlunoUpdateForm(String nome, String bairro, LocalDate dataDeNascimento) {
		this.nome = nome;
		this.bairro = bairro;
		this.dataDeNascimento = dataDeNascimento;
	}

	
	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	
	// Equals e HashCode
	@Override
	public int hashCode() {
		return Objects.hash(bairro, dataDeNascimento, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoUpdateForm other = (AlunoUpdateForm) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(dataDeNascimento, other.dataDeNascimento)
				&& Objects.equals(nome, other.nome);
	}

}
