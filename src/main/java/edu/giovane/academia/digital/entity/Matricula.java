package edu.giovane.academia.digital.entity;

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
@Table(name = "tb_matriculas") // nomeia a tabela
public class Matricula {

	@Id // Define este atributo como chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define a forma como a chave será gerada
	private Long id;

	// Relacionamento Aluno / Matrícula
	@OneToOne(cascade = CascadeType.ALL) // UMA matrícula só tem UM aluno - cascate => Se excluir a matrícula, também
											// exclui o aluno
	private Aluno aluno;
	
	private LocalDateTime dataDaMatricula = LocalDateTime.now();

	
	// Contrutor vazio
	public Matricula() {

	}

	
	
	// Construtor com todos os atributos
	public Matricula(Long id, Aluno aluno, LocalDateTime dataDaMatricula) {
		this.id = id;
		this.aluno = aluno;
		this.dataDaMatricula = dataDaMatricula;
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

	public LocalDateTime getDataDaMatricula() {
		return dataDaMatricula;
	}

	public void setDataDaMatricula(LocalDateTime dataDaMatricula) {
		this.dataDaMatricula = dataDaMatricula;
	}

	
	// Equals e Hashcode
	@Override
	public int hashCode() {
		return Objects.hash(aluno, dataDaMatricula, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(dataDaMatricula, other.dataDaMatricula)
				&& Objects.equals(id, other.id);
	}

}
