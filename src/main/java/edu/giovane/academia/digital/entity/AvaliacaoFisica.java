package edu.giovane.academia.digital.entity;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//import javax.persistence.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

// Classe utilizada para criar a tabela no BD

//@Data // abstrai o Get, Set equals e hashcode
//@NoArgsConstructor // Cria construtor vazio
//@AllArgsConstructor // Cria construtor com todos os atributos

@Entity // Faz a persistência dos dados no BD
@Table(name = "tb_avaliacoes") // nomeia a tabela
public class AvaliacaoFisica {

	@Id // Define este atributo como chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define a forma como a chave será gerada
	private Long id;

	// RELACIONAMENTO
	@ManyToOne(cascade = CascadeType.ALL) // MUITAS avaliações tem UM aluno - cascade = a alteração realizada em
											// avaliacaoFisica será refletida em aluno
	@JoinColumn(name = "aluno_id") // A coluna da foreign key vai estar dentro da tabela de avaliação física
//  @JoinColumn(name = "aluno_id") // foreign key
	private Aluno aluno;

	private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

	@Column(name = "peso_atual") // nome da coluna
	private double peso;

	@Column(name = "altura_atual") // nome da coluna
	private double altura;

	
	// Contrutor vazio
	public AvaliacaoFisica() {

	}
	
	
	// Construtor com todos os atributos
	public AvaliacaoFisica(Long id, Aluno aluno, LocalDateTime dataDaAvaliacao, double peso, double altura) {
		this.id = id;
		this.aluno = aluno;
		this.dataDaAvaliacao = dataDaAvaliacao;
		this.peso = peso;
		this.altura = altura;
	}



	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public LocalDateTime getDataDaAvaliacao() {
		return dataDaAvaliacao;
	}

	public void setDataDaAvaliacao(LocalDateTime dataDaAvaliacao) {
		this.dataDaAvaliacao = dataDaAvaliacao;
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

	
	// Equals e Hashcode
	@Override
	public int hashCode() {
		return Objects.hash(altura, aluno, dataDaAvaliacao, id, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoFisica other = (AvaliacaoFisica) obj;
		return Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura)
				&& Objects.equals(aluno, other.aluno) && Objects.equals(dataDaAvaliacao, other.dataDaAvaliacao)
				&& Objects.equals(id, other.id) && Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso);
	}

}
