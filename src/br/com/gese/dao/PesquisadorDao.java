package br.com.gese.dao;

import java.util.List;

import br.com.gese.model.Pesquisador;
import br.com.gese.util.Url;

public class PesquisadorDao extends ServiceDao {

	private static final String urlPesquisador = Url.pesquisador;

	public List<Pesquisador> getPesquisadores() {
		return getEntidades(urlPesquisador);
	}

	public Pesquisador getPesquisadorId(String id) {
		return getEntidadeId(urlPesquisador, id, Pesquisador.class);
	}

	public void deletePesquisador(int id) {
		deleteEntidade(urlPesquisador, id);
	}

	public void insertPesquisador(Pesquisador pesquisador) {
		insertEntidade(urlPesquisador, pesquisador);
	}

	public void updatePesquisador(Pesquisador pesquisador) {
		updateEntidade(urlPesquisador, pesquisador);
	}
}
