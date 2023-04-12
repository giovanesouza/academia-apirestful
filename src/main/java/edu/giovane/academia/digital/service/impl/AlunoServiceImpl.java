package edu.giovane.academia.digital.service.impl;


import edu.giovane.academia.digital.entity.Aluno;
import edu.giovane.academia.digital.entity.AvaliacaoFisica;
import edu.giovane.academia.digital.entity.form.AlunoForm;
import edu.giovane.academia.digital.entity.form.AlunoUpdateForm;
import edu.giovane.academia.digital.infra.utils.JavaTimeUtils;
import edu.giovane.academia.digital.repository.AlunoRepository;
import edu.giovane.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

// Anotação para indicar service
@Service
public class AlunoServiceImpl implements IAlunoService {

    // Injetação do repository
    @Autowired
    private AlunoRepository alunoRepository;


    // Cadastra novo aluno
    @Override
    public Aluno create(AlunoForm form) {
        // Cria aluno
        Aluno aluno = new Aluno();

        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        // Salva no BD
        return alunoRepository.save(aluno);

    }

    @Override
    public Aluno get(Long id) {
        return null;
    }



    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    
    //    RETORNA LISTA COM TODOS OS ALUNOS
    // Retorna aluno com base na data de nascimento
    @Override
    public List<Aluno> getAll(String dataDeNascimento) {

    	
      if(dataDeNascimento == null) {
        return alunoRepository.findAll();
      } else {
        LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
        return alunoRepository.findByDataDeNascimento(localDate);
      }

    }
    
    
    // Atualização cadastro
    @Override
    public Aluno update(AlunoUpdateForm formUpdate, Long id) {
    	
    	 // Pega o registro no BD
    	Aluno alunoUpdate = alunoRepository.findById(id).get();


        alunoUpdate.setNome(formUpdate.getNome());
        alunoUpdate.setBairro(formUpdate.getBairro());
        alunoUpdate.setDataDeNascimento(formUpdate.getDataDeNascimento());

        // Salva no BD
        return alunoRepository.save(alunoUpdate);
    	
    }


    // Exclui registro - Só é possível excluir se não houver relação com outras tabelas
    @Override
    public void delete(Long id) {
    	alunoRepository.deleteById(id);
    }

    

    // Retorno de todas as avaliações físicas
    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

        // Recupera aluno e pega a lista de avaliações dele
        Aluno aluno = alunoRepository.findById(id).get(); // Pega o aluno

        return aluno.getAvaliacoes(); // Retorna com todas as avaliações
    }



}
