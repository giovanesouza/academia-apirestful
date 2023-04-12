package edu.giovane.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.giovane.academia.digital.entity.Matricula;
import edu.giovane.academia.digital.entity.form.MatriculaForm;
import edu.giovane.academia.digital.service.impl.MatriculaServiceImpl;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
	
	  @Autowired
	  private MatriculaServiceImpl service;

	  @PostMapping // Inserir @Valid antes do REquest para realizar as validações)
	  public Matricula create(@RequestBody MatriculaForm form) {
	    return service.create(form);
	  }

	  @GetMapping
	  public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
	    return service.getAll(bairro);
	  }
	
}
