package edu.giovane.academia.digital.service.impl;

import edu.giovane.academia.digital.entity.Aluno;
import edu.giovane.academia.digital.entity.AvaliacaoFisica;
import edu.giovane.academia.digital.entity.form.AvaliacaoFisicaForm;
import edu.giovane.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import edu.giovane.academia.digital.repository.AlunoRepository;
import edu.giovane.academia.digital.repository.AvaliacaoFisicaRepository;
import edu.giovane.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	// Cria avaliação física
	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();

		// Recupera o aluno do BD
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

		avaliacaoFisica.setAluno(aluno);
		avaliacaoFisica.setPeso(form.getPeso());
		avaliacaoFisica.setAltura(form.getAltura());

		// Salva no BD - Boa prática (retornar uma view com a avaliação física)
		return avaliacaoFisicaRepository.save(avaliacaoFisica);

	}

	@Override
	public AvaliacaoFisica get(Long id) {
		return null;
	}

	// Retorna todas as avaliações físicas
	@Override
	public List<AvaliacaoFisica> getAll() {

		return avaliacaoFisicaRepository.findAll();
	}

	
	// Atualização de cadastro
	@Override
	public AvaliacaoFisica update(AvaliacaoFisicaUpdateForm formUpdate, Long id) {

		// Pega o registro no BD
		AvaliacaoFisica avaliacaoUpdate = avaliacaoFisicaRepository.findById(id).get();

		avaliacaoUpdate.setPeso(formUpdate.getPeso());
		avaliacaoUpdate.setAltura(formUpdate.getAltura());

		// Salva no BD
		return avaliacaoFisicaRepository.save(avaliacaoUpdate);
	}

	@Override
	public void delete(Long id) {
		avaliacaoFisicaRepository.deleteById(id);

	}
}
