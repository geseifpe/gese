package br.com.gese.dao;

import java.net.HttpURLConnection;
import java.util.List;

public interface IDao {
	
	public <T> List<T> getEntidades(String urlEntidade);
	public <T> T getEntidadeId(String urlEntidade, String id, Class<T> entidade);
	public void deleteEntidade(String urlEntidade, int id);
	public <T> void insertEntidade(String urlEntidade, T entidade);
	public <T> void updateEntidade(String urlEntidade, T entidade);
	public HttpURLConnection getHttpConnection(String url, String type);
	public <T> void POST(String url, T entidade);
}	
