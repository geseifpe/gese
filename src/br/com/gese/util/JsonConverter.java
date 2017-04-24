package br.com.gese.util;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
	
public class JsonConverter {
	
	final private Logger logger = Logger.getLogger(JsonConverter.class);
	
	public <T> List<T> converterJsonParaList(String json) {
		Gson gson = new Gson();
		Type tipo = new TypeToken<List<T>>() {
		}.getType();
		List<T> lista = gson.fromJson(json, tipo);
		return lista;
	}

	public <T> T converterJsonParaObjeto(String json, Class<T> entidade) {
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
		gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
		
		try {
			final Gson gson = gsonBuilder.create();
			return gson.fromJson(json, entidade);			
		} catch (Exception e) {
			logger.error(e.getMessage());;
			System.out.println(e.getMessage());
		}
		
		return null;
	}
}
