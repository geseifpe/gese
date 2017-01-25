package br.com.gese.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.core.util.Base64;

import br.com.gese.model.Pesquisador;
import br.com.gese.util.Url;

public class PesquisadorDao {
	private static final Logger LOG = Logger.getLogger(Pesquisador.class.getName());
	private static final String url = Url.urlPrincipal + Url.pesquisador;
	private static final String getPesquisador = "queryAll";
	private static final String getPesquisadorID = "load/";
	private static final String postPesquisador = "insert/";
	private static final String updatePesquisador = "update/";
	private static final String deletePesquisador = "delete/";
	private static final String name = Url.name;
	private static final String password = Url.password;

	public static void main(String[] args) {
		
	}

	/**
	 * Método que retorna uma lista de Pesquisador
	 * 
	 * @return
	 */
	public static List<Pesquisador> getPesquisador() {

		List<Pesquisador> listaCategoria = null;
		try {
			String webPage = url + getPesquisador;

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
			listaCategoria = converterJsonToList(result);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaCategoria;
	}

	public static Pesquisador getPesquisadorId(String id) {

		Pesquisador pesquisador = null;

		try {
			String webPage = url + getPesquisadorID + id;

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
			pesquisador = converterJsonToObjeto(result);
			System.out.println(pesquisador.getCampus_id());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return pesquisador;
	}

	public static void deletePesquisador(int id) {
		getHttpConnection(url + deletePesquisador + id, "DELETE");
	}

	public static void insertPesquisador(Pesquisador pesquisador) {
		
		POST(url + postPesquisador, pesquisador);
		
	}
	
	public static void updatePesquisador(Pesquisador pesquisador) {
		
		POST(url + updatePesquisador, pesquisador);
		
	}

	public static void updateCategorias(int id) {
		// Pesquisador pesquisador = new Pesquisador();
		// pesquisador.setId(id);
		// pesquisador.setNome("Copacabana");
		// pesquisador.setEstado("RJ");
		// POST(url + updatePesquisador, pesquisador);

	}

	private static List<Pesquisador> converterJsonToList(String json) {
		Gson gson = new Gson();
		Type collectionType = new TypeToken<List<Pesquisador>>() {
		}.getType();
		List<Pesquisador> lista = gson.fromJson(json, collectionType);
		return lista;
	}

	private static Pesquisador converterJsonToObjeto(String json) {
		Gson gson = new Gson();		
		Pesquisador pesquisador = gson.fromJson(json, Pesquisador.class);		
		return pesquisador;
	}
	
	// DELETE
	public static HttpURLConnection getHttpConnection(String url, String type) {
		
		URL uri = null;
		HttpURLConnection con = null;
		try {
			String authString = name + ":" + password;
			// System.out.println("auth string: " + authString);
			byte[] authEncBytes = Base64.encode(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			uri = new URL(url);
			con = (HttpURLConnection) uri.openConnection();
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Authorization", "Basic " + authStringEnc);
			con.setRequestMethod(type); // type: POST, PUT, DELETE, GET
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setConnectTimeout(60000); // 60 secs
			con.setReadTimeout(60000); // 60 secs
			con.setRequestProperty("Content-Type", "application/json");
			con.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
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

		return con;
	}

	private static void POST(String uri, Pesquisador pesquisador) {

		try {

			Gson gson = new Gson();
			String produtoJson = gson.toJson(pesquisador);

			System.out.println("Produto serializado (json):");
			System.out.println(produtoJson);

			try {
				String authString = name + ":" + password;
				byte[] authEncBytes = Base64.encode(authString.getBytes());
				String authStringEnc = new String(authEncBytes);
				URL url = new URL(uri);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
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
