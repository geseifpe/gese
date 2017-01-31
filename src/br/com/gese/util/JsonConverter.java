package br.com.gese.util;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonConverter {
	
	public <T> List<T> converterJsonParaList(String json) {
		Gson gson = new Gson();
		Type tipo = new TypeToken<List<T>>() {
		}.getType();
		List<T> lista = gson.fromJson(json, tipo);
		return lista;
	}

	public <T> T converterJsonParaObjeto(String json, Class<T> entidade) {
		Gson gson = new Gson();
		T entidadeObjeto = (T) gson.fromJson(json, entidade);
		return entidadeObjeto;
	}
}
