package br.com.gese.dao;

import java.util.List;
import br.com.gese.model.Aluno;
import br.com.gese.util.Url;

public class AlunoDao extends ServiceDao {

	private static final String urlAluno = Url.aluno;

	public List<Aluno> getAlunos() {
		return getEntidades(urlAluno);
	}

	public Aluno getAlunoId(String id) {
		return getEntidadeId(urlAluno, id, Aluno.class);		
	}

	public void deleteAluno(int id) {
		deleteEntidade(urlAluno, id);
	}

	public void insertAluno(Aluno aluno) {
		insertEntidade(urlAluno, aluno);
	}

	public void updateAluno(Aluno aluno) {
		updateEntidade(urlAluno, aluno);
	}
}
