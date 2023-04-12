package edu.giovane.academia.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import edu.giovane.academia.digital.entity.AvaliacaoFisica;

// Anotação opcional
@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {
	
	/*
	@Query(value = "select * from tb_avaliacoes where aluno_id = :aluno_id", nativeQuery = true)
	public Long findAvaliacoes(Long aluno_id);
	*/

}
