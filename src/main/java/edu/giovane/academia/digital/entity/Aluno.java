package edu.giovane.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//import javax.persistence.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Classe utilizada para criar a tabela no BD

//@Data // abstrai o Get, Set equals e hashcode
//@NoArgsConstructor // Cria construtor vazio
//@AllArgsConstructor // Cria construtor com todos os atributos

@Entity // Faz a persistência dos dados no BD
@Table(name = "tb_alunos") // nomeia a tabela
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // Necessário usar por causa da Inicialização Lenta da
																	// lista
public class Aluno {

	@Id // Define este atributo como chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define a forma como a chave será gerada
	private Long id;

	// A coluna receberá o nome deste atributo
	private String nome;

	@Column(unique = true) // O CPF é unico, não pode haver outros cadastros com cpf =
	private String cpf;

	private String bairro;

	private LocalDate dataDeNascimento;

	
	// Relação Aluno / AvaliacaoFisica
	@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) // UM aluno pode ter VÁRIAS avaliações física
	// - fetch = tipo de carregamento da lista
	@JsonIgnore // Trata exceptions Json
	private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

	
	// Contrutor vazio
	public Aluno() {

	}

// Construtor com todos os atributos
	public Aluno(Long id, String nome, String cpf, String bairro, LocalDate dataDeNascimento,
			List<AvaliacaoFisica> avaliacoes) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.bairro = bairro;
		this.dataDeNascimento = dataDeNascimento;
		this.avaliacoes = avaliacoes;
	}

// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<AvaliacaoFisica> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	
	
	// Equals e Hashcode
	@Override
	public int hashCode() {
		return Objects.hash(avaliacoes, bairro, cpf, dataDeNascimento, id, nome);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(avaliacoes, other.avaliacoes) && Objects.equals(bairro, other.bairro)
				&& Objects.equals(cpf, other.cpf) && Objects.equals(dataDeNascimento, other.dataDeNascimento)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

}