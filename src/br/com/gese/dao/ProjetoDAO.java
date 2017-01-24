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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.core.util.Base64;

import br.com.gese.model.Projeto;
import br.com.gese.util.Url;

public class ProjetoDAO {
	private static final Logger LOG = Logger.getLogger(Projeto.class.getName());
	private static final String url = Url.urlPrincipal + Url.projeto;
	private static final String getProjeto = "queryAll";
	private static final String getProjetoID = "load/";
	private static final String postProjeto = "insert/";
	private static final String updateProjeto = "update/";
	private static final String deleteProjeto = "delete/";
	private static final String name = Url.name;
	private static final String password = Url.password;

	public static void main(String[] args) {

	}

	/**
	 * Método que retorna uma lista de Projeto
	 * @return
	 */
	public static List<Projeto> getProjeto() {
		List<Projeto> listaCategoria = null;
		
		try {
			
			String webPage = url+getProjeto;
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
	
	public static List<Projeto> getProjetoId(int id) {
		Projeto Projeto = null;
		List<Projeto> listaProjeto = new ArrayList<Projeto>();
		
		try {
			String webPage = url + getProjetoID + id;
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
			Projeto = converterJsonToObjeto(result);
			listaProjeto.add(Projeto);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return listaProjeto;
	}

	public static void deleteProjeto(int id) {
		getHttpConnection(url+deleteProjeto+id, "DELETE");
	}

	public static void insertProjeto(Projeto Projeto) {
		POST(url+postProjeto, Projeto);

	}

	public static void updateCategorias(int id) {
		Projeto projeto = new Projeto();
		projeto.setNota(10);
		projeto.setTitulo("Projeto teste");		
		POST(url+updateProjeto, projeto);
	}


	private static List<Projeto> converterJsonToList(String json) {  
		Gson gson = new Gson();
		Type collectionType = new TypeToken<List<Projeto>>(){}.getType();
		List<Projeto> lista = gson.fromJson(json, collectionType);
		return lista; 
	}
	
	private static Projeto converterJsonToObjeto(String json) {  
		Gson gson = new Gson();		
		Projeto Projeto = gson.fromJson(json, Projeto.class);
		return Projeto; 
	}


	//DELETE
	public  static HttpURLConnection getHttpConnection(String url, String type){
		URL uri = null;
		HttpURLConnection con = null;
		try{
			String authString = name + ":" + password;
			//System.out.println("auth string: " + authString);
			byte[] authEncBytes = Base64.encode(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			uri = new URL(url);
			con = (HttpURLConnection) uri.openConnection();
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Authorization", "Basic " + authStringEnc);
			con.setRequestMethod(type); //type: POST, PUT, DELETE, GET
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setConnectTimeout(60000); //60 secs
			con.setReadTimeout(60000); //60 secs
			con.setRequestProperty("Content-Type", "application/json");
			con.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String temp = null;
			StringBuilder sb = new StringBuilder();
			while((temp = in.readLine()) != null){
				sb.append(temp).append(" ");
			}
			sb.toString();
			in.close();
		}catch(Exception e){
			System.out.println( "connection i/o failed" );
		}
		return con;
	}

	private static void POST(String uri, Projeto categoria){
		try {		
			Gson gson = new Gson();
			String produtoJson = gson.toJson(categoria);
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
