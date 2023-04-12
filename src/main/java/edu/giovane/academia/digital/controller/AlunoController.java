package edu.giovane.academia.digital.controller;

import edu.giovane.academia.digital.entity.Aluno;
import edu.giovane.academia.digital.entity.AvaliacaoFisica;
import edu.giovane.academia.digital.entity.form.AlunoForm;
import edu.giovane.academia.digital.entity.form.AlunoUpdateForm;
import edu.giovane.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	// Injeta o Service
	@Autowired
	private AlunoServiceImpl service;

	// Método para retornar uma lista com todos os alunos
	@GetMapping // Anotação para obter retorno
	public List<Aluno> getAll() {
		return service.getAll();
	}

	// Método para criar um aluno
	@PostMapping // Para envio de dados
	// @Valid faz com que a validação seja realizada (Inserir antes do RequestBody
	public Aluno create(@RequestBody AlunoForm form) { // Corpo da requisição recebe o formulaário para cadastro
		return service.create(form);
	}

	// Retorna todas as avaliações físicas de um aluno (Quando chamar a rota
	// /alunos/avaliacoes/id -> Lista todas as avaliações do aluno
	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
		return service.getAllAvaliacaoFisicaId(id);
	}

	// Atualiza registro
	@PutMapping("/{id}")
	public Aluno update(@RequestBody AlunoUpdateForm formUpdate, @PathVariable Long id) {

	return service.update(formUpdate, id);

	}
	
	// EXCLUI UM CADASTRO VIA ID >> alunos/id
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {

		service.delete(id);

	}

	/*
	 * // Retorno com base na data de nascimento
	 * 
	 * @GetMapping public List<Aluno> getAll(@RequestParam(value =
	 * "dataDeNascimento", required = false) String dataDeNacimento) { return
	 * service.getAll(dataDeNacimento); }
	 */

}
