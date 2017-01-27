package br.com.gese.dao;

import java.util.List;
import com.sun.jersey.core.util.Base64;

import br.com.gese.model.Usuario;
import br.com.gese.util.JsonConverter;
import br.com.gese.util.Url;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UsuarioDao extends ServiceDao {
	
	private static final String urlUsuario = Url.usuario;
	private static final String getLoginUsuario = "login/";
	private static final String name = Url.name;
	private static final String password = Url.password;

	public List<Usuario> getUsuarios() {
		return getEntidade(urlUsuario);
	}

	public Usuario getUsuarioId(String id) {
		return getEntidadeId(urlUsuario, id, Usuario.class);
	}

	public void deleteUsuario(int id) {
		deleteEntidade(urlUsuario, id);
	}

	public void insertUsuario(Usuario usuario) {
		insertEntidade(urlUsuario, usuario);
	}

	public void updateUsuario(Usuario usuario) {
		updateEntidade(urlUsuario, usuario);
	}

	public Usuario login(String cpf, String senha) {

		Usuario usuario = null;

		try {
			String webPage = Url.urlPrincipal + urlUsuario + getLoginUsuario + cpf + "/" + senha;

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
			usuario = new JsonConverter().converterJsonParaObjeto(result, Usuario.class);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return usuario;
	}
}
