package br.com.gese.dao;

import java.util.List;

import br.com.gese.model.ProjetoPesquisador;
import br.com.gese.util.Url;

public class ProjetoPesquisadorDao extends ServiceDao {

	private static final String urlProjetoPesquisador = Url.projetoPesquisador;

	public List<ProjetoPesquisador> getProjetosPesquisador() {
		return getEntidades(urlProjetoPesquisador);
	}

	public ProjetoPesquisador getProjetoPesquisadorId(String id) {
		return getEntidadeId(urlProjetoPesquisador, id, ProjetoPesquisador.class);
	}

	public void deleteProjetoPesquisador(int id) {
		deleteEntidade(urlProjetoPesquisador, id);
	}

	public void insertProjetoPesquisador(ProjetoPesquisador projetoPesquisador) {
		insertEntidade(urlProjetoPesquisador, projetoPesquisador);
	}

	public void updateProjetoPesquisador(ProjetoPesquisador projetoPesquisador) {
		updateEntidade(urlProjetoPesquisador, projetoPesquisador);
	}
}
