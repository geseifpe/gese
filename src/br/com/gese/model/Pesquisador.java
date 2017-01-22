package br.com.gese.model;

import com.google.gson.annotations.SerializedName;

public class Pesquisador {
	
	@SerializedName("siape")
	private String siape;
	
	@SerializedName("cpf")
	private String cpf;
	
	@SerializedName("nome")
	private String nome;
	
	@SerializedName("cargo")
	private char cargo;
	
	@SerializedName("titulacao")
	private char titulacao;
	
	@SerializedName("sexo")
	private char sexo;
	
	@SerializedName("regime")
	private String regime;
			
	@SerializedName("campus_id")
	private int campusId;
	
	@SerializedName("departamento_id")
	private int departamento_id;
	
	@SerializedName("telefone")
	private String telefone;
	
	@SerializedName("celular")
	private String celular;
	
	@SerializedName("email1")
	private String email1;

	@SerializedName("email2")
	private String email2;

	@SerializedName("linklattes")
	private String linklattes;
	
	@SerializedName("area_codigo")
	private String area_codigo;
	
	public String getSiape() {
		return siape;
	}
	
	public void setSiape(String siape) {
		this.siape = siape;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;	
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;		
	}
	
	public char getCargo() {
		return cargo;
	}
	
	public void setCargo(char cargo) {
		this.cargo = cargo;		
	}
	
	public char getTitulacao() {
		return titulacao;
	}
	
	public void setTitulacao(char titulacao) {
		this.titulacao = titulacao;		
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String getSexoCompleto(){
		if(this.sexo == 'M'){
			return "Masculino";
		}else{
			return "Feminino";
		}
	}
	
	public String getTitulacaoCompleta(){
		if(this.titulacao == 'M'){
			return "Mestrado";
		}else{
			return "Doutorado";
		}
	}
	
	public String getRegime() {
		return regime;
	}
	
	public void setRegime(String regime) {
		this.regime = regime;
	}
	
	
	public int getCampusId() {
		return campusId;
	}

	public void setCampusId(int campus_id) {
		this.campusId = campus_id;
	}

	public int getDepartamento() {
		return departamento_id;
	}
	
	public void setDepartamento(int departamento_id) {
		this.departamento_id = departamento_id;		
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;		
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;		
	}
	
	public String getEmail1() {
		return email1;
	}
	
	public void setEmail1(String email1) {
		this.email1 = email1;		
	}
	
	public String getEmail2() {
		return email2;
	}
	
	public void setEmail2(String email2) {
		this.email2 = email2;		
	}

	
	public String getLinklattes() {
		return linklattes;
	}

	public void setLinklattes(String linklattes) {
		this.linklattes = linklattes;
	}

	public String getArea_codigo() {
		return area_codigo;
	}

	public void setArea_codigo(String area_codigo) {
		this.area_codigo = area_codigo;
	}
	
	
	
	
}

