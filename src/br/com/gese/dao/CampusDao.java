package br.com.gese.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.core.util.Base64;

import br.com.gese.model.Campus;
import br.com.gese.util.Url;

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
import java.util.logging.Logger;

public class CampusDao {
	private static final Logger LOG = Logger.getLogger(Campus.class.getName());
	private static final String url = Url.urlPrincipal+Url.campus;
	private static final String getCampus = "queryAll";
	private static final String getCampusID = "load/";
	private static final String postCampus = "insert/";
	private static final String updateCampus = "update/";
	private static final String deleteCampus = "delete/";
	private static final String name = Url.name;
	private static final String password = Url.password;

	public static void main(String[] args) {
		
	}

	/**
	 * Método que retorna uma lista de campus
	 * @return
	 */
	public static List<Campus> getCampus() {
		List<Campus> listaCategoria = null;
		
		try {
			
			String webPage = url+getCampus;
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
	
	public static List<Campus> getCampusId(int id) {
		Campus campus = null;
		List<Campus> listaCampus = new ArrayList<Campus>();
		
		try {
			String webPage = url+getCampusID+id;


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
			campus = converterJsonToObjeto(result);
			listaCampus.add(campus);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return listaCampus;
	}


	
	public static void deleteCampus(int id) {
		getHttpConnection(url+deleteCampus+id, "DELETE");
	}

	public static void insertCampus(Campus campus) {
		POST(url+postCampus, campus);
	}

	public static void updateCategorias(int id) {
		Campus campus = new Campus();
		campus.setId(id);
		campus.setNome("Copacabana");
		campus.setEstado("RJ");
		POST(url+updateCampus, campus);

	}


	private static List<Campus> converterJsonToList(String json) {  
		Gson gson = new Gson();
		Type collectionType = new TypeToken<List<Campus>>(){}.getType();
		List<Campus> lista = gson.fromJson(json, collectionType);
		return lista; 
	}
	
	private static Campus converterJsonToObjeto(String json) {  
		Gson gson = new Gson();		
		Campus Campus = gson.fromJson(json, Campus.class);
		return Campus; 
	}


	//DELETE
	public  static HttpURLConnection getHttpConnection(String url, String type){		
		URL uri = null;
		HttpURLConnection con = null;
		String result = null;
		
		try{
			
			String authString = name + ":" + password;			
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
			result = sb.toString();
			in.close();
		}catch(Exception e){
			System.out.println( "connection i/o failed" );
		}

		return con;
	}

	private static void POST(String uri, Campus categoria){

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

