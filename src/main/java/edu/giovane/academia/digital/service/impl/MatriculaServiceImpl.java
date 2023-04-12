package edu.giovane.academia.digital.service.impl;

import edu.giovane.academia.digital.entity.Aluno;
import edu.giovane.academia.digital.entity.Matricula;
import edu.giovane.academia.digital.entity.form.MatriculaForm;
import edu.giovane.academia.digital.repository.AlunoRepository;
import edu.giovane.academia.digital.repository.MatriculaRepository;
import edu.giovane.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

  @Autowired
  private MatriculaRepository matriculaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  
  @Override
  public Matricula create(MatriculaForm form) {
    Matricula matricula = new Matricula();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    matricula.setAluno(aluno);

    return matriculaRepository.save(matricula);
  }

  
  @Override
  public Matricula get(Long id) {
    return matriculaRepository.findById(id).get();
  }

  
  @Override
  public List<Matricula> getAll(String bairro) {

    if(bairro == null){
      return matriculaRepository.findAll();
      
    }else{
      return matriculaRepository.findAlunosMatriculadosBairro(bairro);
    }

  }
  

  @Override
  public void delete(Long id) {}


@Override
public List<Matricula> getAll() {
	// TODO Auto-generated method stub
	return null;
}

 




}
