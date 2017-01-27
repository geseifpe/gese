package br.com.gese.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.core.util.Base64;

import br.com.gese.util.JsonConverter;
import br.com.gese.util.LocalDateDeserializer;
import br.com.gese.util.LocalDateSerializer;
import br.com.gese.util.Url;

public class ServiceDao implements IDao{
	
	private static final String urlPrincipal = Url.urlPrincipal;
	private static final String getentidade = "queryAll";
	private static final String getentidadeID = "load/";
	private static final String insertentidade = "insert/";
	private static final String updateentidade = "update/";
	private static final String deleteentidade = "delete/";
	private static final String name = Url.name;
	private static final String password = Url.password;

	public <T> List<T> getEntidades(String urlEntidade) {

		List<T> listaDeentidades = null;

		try {
			String webPage = urlPrincipal + urlEntidade + getentidade;

			String authString = name + ":" + password;
			System.out.println("auth string: " + authString);
			byte[] authEncBytes = Base64.encode(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			System.out.println("Base64 encoded auth string: " + authStringEnc);

			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			String result = sb.toString();
			System.out.println(result);
			listaDeentidades =  new JsonConverter().converterJsonParaList(result);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaDeentidades;
	}

	@SuppressWarnings("unchecked")
	public <T> T getEntidadeId(String urlEntidade, String id, Class<T> entidade) {

		T entidadeObjeto = null;

		try {
			String webPage = urlPrincipal + urlEntidade + getentidadeID + id;

			String authString = name + ":" + password;
			System.out.println("auth string: " + authString);
			byte[] authEncBytes = Base64.encode(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			System.out.println("Base64 encoded auth string: " + authStringEnc);

			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			
			String result = sb.toString();
			System.out.println(result);			
			
			entidadeObjeto = (T) new JsonConverter().converterJsonParaObjeto(result, (Class<T>)entidadeObjeto); //suppress warning

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return entidadeObjeto;
	}

	public void deleteEntidade(String urlEntidade, int id) {
		getHttpConnection(urlPrincipal + urlEntidade + deleteentidade + id, "DELETE");
	}

	public <T> void insertEntidade(String urlEntidade, T entidade) {
		POST(urlPrincipal + urlEntidade + insertentidade, entidade);
	}

	public <T> void updateEntidade(String urlEntidade, T entidade) {
		POST(urlPrincipal + urlEntidade + updateentidade, entidade);
	}

	public void updateentidade(int id) {
	}

	public HttpURLConnection getHttpConnection(String url, String type) {
		
		URL urlObject = null;
		HttpURLConnection connection = null;
		
		try {

			String authString = name + ":" + password;
			byte[] authEncBytes = Base64.encode(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			urlObject = new URL(urlPrincipal + url);
			connection = (HttpURLConnection) urlObject.openConnection();
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			connection.setRequestMethod(type); // type: POST, PUT, DELETE, GET
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setConnectTimeout(60000); // 60 secs
			connection.setReadTimeout(60000); // 60 secs
			connection.setRequestProperty("Content-Type", "application/json");
			connection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String temp = null;
			StringBuilder sb = new StringBuilder();
			while ((temp = in.readLine()) != null) {
				sb.append(temp).append(" ");
			}
			sb.toString();
			in.close();
		} catch (Exception e) {
			System.out.println("connection i/o failed");
		}

		return connection;
	}

	public <T> void POST(String url, T entidade) {

		Logger LOG = Logger.getLogger(entidade.getClass().getName());

		try {

			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
			gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());

			Gson gson = gsonBuilder.create();
			String produtoJson = gson.toJson(entidade);

			System.out.println("Produto serializado (json):");
			System.out.println(produtoJson);

			try {
				String authString = name + ":" + password;
				byte[] authEncBytes = Base64.encode(authString.getBytes());
				String authStringEnc = new String(authEncBytes);
				URL urlObject = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setRequestProperty("Authorization", "Basic " + authStringEnc);
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);

				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(produtoJson);
				out.close();

				int http_status = connection.getResponseCode();
				if (http_status / 100 != 2) {
					LOG.log(Level.SEVERE, "Ocorreu algum erro. Codigo de reposta: {0}", http_status);
				}

				try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
					String line;
					while ((line = reader.readLine()) != null) {
						System.out.println(line);
					}
				}
			} catch (Exception e) {
				LOG.log(Level.SEVERE, null, e);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, null, e);
		}
	}
}
