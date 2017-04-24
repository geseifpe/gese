package br.com.gese.util;

import java.lang.reflect.Type;
import java.time.LocalDate;

import org.springframework.expression.ParseException;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class LocalDateDeserializer implements JsonDeserializer<LocalDate> {

	@Override
	public LocalDate deserialize(JsonElement jsonDate, Type type, JsonDeserializationContext context)
			throws JsonParseException {
		try {			
			return LocalDate.parse(jsonDate.getAsString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
