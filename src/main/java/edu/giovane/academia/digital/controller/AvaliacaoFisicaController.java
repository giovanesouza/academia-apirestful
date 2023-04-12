package edu.giovane.academia.digital.controller;

//import edu.giovane.academia.digital.entity.Aluno;
import edu.giovane.academia.digital.entity.AvaliacaoFisica;
//import edu.giovane.academia.digital.entity.form.AlunoUpdateForm;
import edu.giovane.academia.digital.entity.form.AvaliacaoFisicaForm;
import edu.giovane.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import edu.giovane.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

	@Autowired
	private AvaliacaoFisicaServiceImpl service;

	// Cria avaliação física
	@PostMapping
	public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
		return service.create(form);
	}

	@GetMapping
	public List<AvaliacaoFisica> getAll() {
		return service.getAll();
	}

	// Atualiza registro
	@PutMapping("/{id}")
	public AvaliacaoFisica update(@RequestBody AvaliacaoFisicaUpdateForm formUpdate, @PathVariable Long id) {

		return service.update(formUpdate, id);

	}
	

	// EXCLUI UM CADASTRO VIA ID >> avaliacoes/id
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {

		service.delete(id);

	}

	
	

}