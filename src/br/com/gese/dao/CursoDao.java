package br.com.gese.dao;

import java.util.List;

import br.com.gese.model.Curso;
import br.com.gese.util.Url;

public class CursoDao extends ServiceDao{
	private static final String urlCurso = Url.curso;

	public List<Curso> getCursos() {
		return getEntidade(urlCurso);
	}
	
	public Curso getCampusId(String id) {
		return getEntidadeId(urlCurso, id, Curso.class);
	}
	
	public void deleteCurso(int id) {
		deleteEntidade(urlCurso, id);
	}

	public void insertCurso(Curso curso) {
		insertEntidade(urlCurso, curso);
	}
	
	public void updateCurso(Curso curso) {
		updateEntidade(urlCurso, curso);
	}
}