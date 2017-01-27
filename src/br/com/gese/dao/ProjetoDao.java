package br.com.gese.dao;

import java.util.List;

import br.com.gese.model.Projeto;
import br.com.gese.util.Url;

public class ProjetoDao extends ServiceDao {

	private static final String urlProjeto = Url.projeto;

	public List<Projeto> getProjetos() {
		return getEntidade(urlProjeto);
	}

	public Projeto getProjetoId(String id) {
		return getEntidadeId(urlProjeto, id, Projeto.class);
	}

	public void deleteProjeto(int id) {
		deleteEntidade(urlProjeto, id);
	}

	public void insertProjeto(Projeto projeto) {
		insertEntidade(urlProjeto, projeto);
	}

	public void updateProjeto(Projeto projeto) {
		updateEntidade(urlProjeto, projeto);
	}
}
