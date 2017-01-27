package br.com.gese.dao;

import java.util.List;
import br.com.gese.model.Campus;
import br.com.gese.util.Url;

public class CampusDao extends ServiceDao {

	private static final String urlCampus = Url.campus;

	public List<Campus> getCampus() {
		return getEntidade(urlCampus);
	}

	public Campus getCampusId(String id) {
		return getEntidadeId(urlCampus, id, Campus.class);
	}

	public void deleteCampus(int id) {
		deleteEntidade(urlCampus, id);
	}

	public void insertCampus(Campus campus) {
		insertEntidade(urlCampus, campus);
	}

	public void updateCampus(Campus campus) {
		updateEntidade(urlCampus, campus);
	}
}
